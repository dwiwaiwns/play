package com.pzhang7.study.test.core.img;

import org.apache.log4j.NDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileDuplicateTest {

    private static final Logger logger = LoggerFactory.getLogger(FileDuplicateTest.class);

    public static void main(String[] args) {
        renameFile();
    }

    public static void renameFile() {
        Map<String, Img> map = new HashMap<>();
        File dir = new File("E:\\2");
        File[] files = null;
        if (dir.exists()) {
            files = dir.listFiles();
            for (int i = 0; i < files.length; i++) {
                String fileName = getFileName(files[i]).toLowerCase();
                Img img = map.get(fileName);
                if (img == null) {
                    img = new Img(fileName);
                    map.put(fileName, img);
                }
                img.setFile(files[i]);
            }
            logger.info("map.size = {}", map.size());
            for (Img img : map.values()) {
                img.updateTime();
            }

            Img[] imgs = new Img[map.size()];
            int index = 0;
            for (Img img : map.values()) {
                imgs[index++] = img;
            }
            Arrays.sort(imgs, new ComparatorImgByLastModified(SortType.ASC));
            for (int i = 0; i < imgs.length; i++) {
                imgs[i].setNewName(getFlag(i));
            }
        } else {
            logger.error("该目录没有任何文件信息！");
        }
        logger.info("finished");
    }

    public static String getFlag(int i) {
        if (i < 10) {
            return "IMG_000" + i;
        } else if (i < 100) {
            return "IMG_00" + i;
        } else if (i < 1000) {
            return "IMG_0" + i;
        } else if (i < 10000) {
            return "IMG_" + i;
        }
        return null;
    }

    public static String getFileName(File file) {
        String fileName = file.getName();
        if (fileName.indexOf("IMG_1566") != -1) {
            System.out.println("");
        }
        fileName = fileName.substring(0, fileName.lastIndexOf("."));
        fileName = fileName.replace(" （已编辑）", "");
        fileName = fileName.replace("_HEVC", "");
        return fileName;
    }

    public static void deleteDuplicateFile() {
        // String[] filePaths = new String[]{"E:\\新建文件夹\\2015", "E:\\新建文件夹\\2016", "E:\\新建文件夹\\2018"};
        String[] filePaths = new String[]{"E:\\新建文件夹"};
        for (String filePath : filePaths) {
            try {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        deleteDuplicateFile4OnePath(filePath);
                    }
                }).start();
            } catch (Exception e) {
            }
        }
        NDC.clear();
    }

    public static void deleteDuplicateFile4OnePath(String path) {
        try {
            //读取文件
            File[] filesAsc = FileDuplicateTest.getFiles(path, SortType.ASC);
            String[] fileAscMD5 = new String[filesAsc.length];
            for (int i = 0; i < filesAsc.length; i++) {
                fileAscMD5[i] = getFileMD5(filesAsc[i]);
            }
            for (int i = filesAsc.length - 1; i >= 0; i--) {
                try {
                    File currentFile = filesAsc[i];
                    NDC.push(path + " " + i + " " + currentFile.getName());
                    boolean hasDuplicateFile = hasDuplicateFile(filesAsc, fileAscMD5, currentFile, i);
                    if (hasDuplicateFile) {
                        currentFile.delete();
                    }
                } catch (Exception e) {
                    logger.error("error: ", e);
                } finally {
                    NDC.pop();
                }
            }
        } catch (Exception e) {
        }
    }

    public static boolean hasDuplicateFile(File[] filesAsc, String[] fileAscMD5, File file, int currentFileIndex) {
        String currentFileMD5 = fileAscMD5[currentFileIndex];
        for (int i = 0; i < filesAsc.length; i++) {
            if (i == currentFileIndex) {
                continue;
            }
            if (currentFileMD5.equals(fileAscMD5[i])) {
                logger.info("compare at: {}, file name: {}, file is equals. process file: {}, tmp file: {}", new Object[]{i, filesAsc[i].getName(), file.getName(), filesAsc[i].getName()});
                return true;
            }
        }
        return false;
    }

    /**
     * 读取目录文件
     *
     * @param dirName 目录名称
     * @return list集合
     */
    public static File[] getFiles(String dirName, SortType sortType) {
        File dir = new File(dirName);
        File[] files = null;
        if (dir.exists()) {
            files = dir.listFiles();
            //排序
            Arrays.sort(files, new FileDuplicateTest.ComparatorByLastModified(sortType));
        } else {
            logger.error("该目录没有任何文件信息！");
        }
        return files;
    }

    /**
     * 格式化时间
     *
     * @param format 格式化显示样式
     * @param date   时间
     * @return
     */
    private static String format(String format, Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    /**
     * 进行文件排序时间
     *
     * @author 谈情
     */
    private static class ComparatorImgByLastModified implements Comparator<Img> {

        private SortType sortType;

        public ComparatorImgByLastModified(SortType sortType) {
            this.sortType = sortType;
        }

        public int compare(Img f1, Img f2) {
            long diff = f1.getTime() - f2.getTime();
            if (diff > 0)
                return 1 * sortType.getFlag();
            else if (diff == 0)
                return 0 * sortType.getFlag();
            else
                return -1 * sortType.getFlag();
        }

        public boolean equals(Object obj) {
            return true;
        }
    }

    /**
     * 进行文件排序时间
     *
     * @author 谈情
     */
    private static class ComparatorByLastModified implements Comparator<File> {

        private SortType sortType;

        public ComparatorByLastModified(SortType sortType) {
            this.sortType = sortType;
        }

        public int compare(File f1, File f2) {
            long diff = f1.lastModified() - f2.lastModified();
            if (diff > 0)
                return 1 * sortType.getFlag();
            else if (diff == 0)
                return 0 * sortType.getFlag();
            else
                return -1 * sortType.getFlag();
        }

        public boolean equals(Object obj) {
            return true;
        }
    }

    private enum SortType {
        ASC(1),
        DESC(-1),
        ;

        private int flag;

        public int getFlag() {
            return flag;
        }

        SortType(int flag) {
            this.flag = flag;
        }
    }

    // 计算文件的 MD5 值
    public static String getFileMD5(File file) {
        if (!file.isFile()) {
            return null;
        }
        MessageDigest digest = null;
        FileInputStream in = null;
        byte buffer[] = new byte[8192];
        int len;
        try {
            digest = MessageDigest.getInstance("MD5");
            in = new FileInputStream(file);
            while ((len = in.read(buffer)) != -1) {
                digest.update(buffer, 0, len);
            }
            BigInteger bigInt = new BigInteger(1, digest.digest());
            return bigInt.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
