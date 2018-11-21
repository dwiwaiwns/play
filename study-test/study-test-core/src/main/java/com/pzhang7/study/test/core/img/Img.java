package com.pzhang7.study.test.core.img;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Img {

    private String oldName;
    private String newName;
    private File png;
    private File jpg;
    private File mov;
    private File heic;
    private File hevcMov;
    private File editedHeic;
    private File editedJpg;

    private long time;

    public Img(String oldName) {
        this.oldName = oldName.toLowerCase();
    }

    public void updateTime() {
        if (jpg != null) {
            Date date = getDate();
            if (date == null) {
                System.out.println("获取创建时间失败：" + toString());
                this.setTime(jpg.lastModified());
            }else {
                this.setTime(date.getTime());
            }
        } else if (png != null) {
            this.setTime(png.lastModified());
        } else {
            System.out.println(this.toString() + " -- 没有时间");
        }
    }

    private Date getDate() {
        Metadata metadata = null;
        Date date = null;
        try {
            metadata = ImageMetadataReader.readMetadata(jpg);
        } catch (ImageProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Directory directory : metadata.getDirectories()) {
            for (Tag tag : directory.getTags()) {
                String tagName = tag.getTagName();  //标签名
                String desc = tag.getDescription(); //标签信息
                if (tagName.equals("Date/Time Original")) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
                    try {
                        date = formatter.parse(desc);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return date;
    }

    private void updateName() {
        if (png != null) {
            String newFileName = png.getParent() + "\\" + this.getNewName() + ".PNG";
            // System.out.println(newFileName);
            png.renameTo(new File(newFileName));
        }
        if (jpg != null) {
            String newFileName = jpg.getParent() + "\\" + this.getNewName() + ".jpg";
            // System.out.println(newFileName);
            jpg.renameTo(new File(newFileName));
        }
        if (mov != null) {
            String newFileName = mov.getParent() + "\\" + this.getNewName() + ".MOV";
            // System.out.println(newFileName);
            mov.renameTo(new File(newFileName));
        }
        if (heic != null) {
            String newFileName = heic.getParent() + "\\" + this.getNewName() + ".HEIC";
            // System.out.println(newFileName);
            heic.renameTo(new File(newFileName));
        }
        if (hevcMov != null) {
            String newFileName = hevcMov.getParent() + "\\" + this.getNewName() + "_HEVC.MOV";
            // System.out.println(newFileName);
            hevcMov.renameTo(new File(newFileName));
        }
        if (editedHeic != null) {
            String newFileName = editedHeic.getParent() + "\\" + this.getNewName() + " （已编辑）.heic";
            // System.out.println(newFileName);
            editedHeic.renameTo(new File(newFileName));
        }
        if (editedJpg != null) {
            String newFileName = editedJpg.getParent() + "\\" + this.getNewName() + " （已编辑）.jpg";
            // System.out.println(newFileName);
            editedJpg.renameTo(new File(newFileName));
        }
    }

    public void setFile(File file) {
        String fileName = file.getName().toLowerCase();
        if (fileName.indexOf("e0bb7e4914f5e402459c171ebce2af2e") != -1 || fileName.toLowerCase().indexOf("IMG_1566") != -1) {
            System.out.println("");
        }
        if (fileName.indexOf(".png".toLowerCase()) != -1) {
            this.setPng(file);
        } else if (fileName.equals(oldName + ".jpg".toLowerCase())) {
            this.setJpg(file);
        } else if (fileName.equals(oldName + ".mov".toLowerCase())) {
            this.setMov(file);
        } else if (fileName.equals(oldName + ".heic".toLowerCase())) {
            this.setHeic(file);
        } else if (fileName.indexOf("hevc.mov".toLowerCase()) != -1) {
            this.setHevcMov(file);
        } else if (fileName.indexOf(" （已编辑）.heic".toLowerCase()) != -1) {
            this.setEditedHeic(file);
        } else if (fileName.indexOf(" （已编辑）.jpg".toLowerCase()) != -1) {
            this.setEditedJpg(file);
        }
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
        updateName();
    }

    public File getPng() {
        return png;
    }

    public void setPng(File png) {
        this.png = png;
    }

    public File getJpg() {
        return jpg;
    }

    public void setJpg(File jpg) {
        this.jpg = jpg;
    }

    public File getMov() {
        return mov;
    }

    public void setMov(File mov) {
        this.mov = mov;
    }

    public File getHeic() {
        return heic;
    }

    public void setHeic(File heic) {
        this.heic = heic;
    }

    public File getHevcMov() {
        return hevcMov;
    }

    public void setHevcMov(File hevcMov) {
        this.hevcMov = hevcMov;
    }

    public File getEditedHeic() {
        return editedHeic;
    }

    public void setEditedHeic(File editedHeic) {
        this.editedHeic = editedHeic;
    }

    public File getEditedJpg() {
        return editedJpg;
    }

    public void setEditedJpg(File editedJpg) {
        this.editedJpg = editedJpg;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Img{" +
                "oldName='" + oldName + '\'' +
                ", newName='" + newName + '\'' +
                ", png=" + (png == null ? null : png.getName()) +
                ", jpg=" + (jpg == null ? null : jpg.getName()) +
                ", mov=" + (mov == null ? null : mov.getName()) +
                ", heic=" + (heic == null ? null : heic.getName()) +
                ", hevcMov=" + (hevcMov == null ? null : hevcMov.getName()) +
                ", editedHeic=" + (editedHeic == null ? null : editedHeic.getName()) +
                ", editedJpg=" + (editedJpg == null ? null : editedJpg.getName()) +
                ", time=" + time +
                '}';
    }
}
