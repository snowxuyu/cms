package org.snow.cms.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.snow.cms.model.BackupFile;

public class BackupFileUtil {
    private static BackupFileUtil util;
    private String backupFile;
    private static String realPath;
    private String database;
    private String username;
    private String password;
    private List<String> backupFiles;
    private static final String DATABASE_NAME = "database";
    private static final String BACKUP_NAME = "backup";

    private BackupFileUtil()
            throws IOException {
        Properties prop = new Properties();
        prop.load(BackupFileUtil.class.getClassLoader().getResourceAsStream("backup.properties"));
        this.database = prop.getProperty("database");
        this.username = prop.getProperty("database_username");
        this.password = prop.getProperty("database_password");
        this.backupFile = prop.getProperty("backupFile");
        File bf = new File(realPath + File.separator + this.backupFile);
        if (!bf.exists()) bf.mkdirs();
        this.backupFiles = new ArrayList();

        String fs = prop.getProperty("file");
        String[] fas = fs.split(",");
        for (String f : fas)
            this.backupFiles.add(f);
    }

    public static BackupFileUtil getInstance(String realPath) {
        try {
            realPath = realPath;
            if (util == null) util = new BackupFileUtil();
            return util;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<BackupFile> listBackups() {
        File[] fs = new File(realPath + File.separator + this.backupFile).listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                if (pathname.isDirectory())
                    return false;
                return true;
            }
        });
        List bs = new ArrayList();
        BackupFile bf = null;
        for (File f : fs) {
            bf = new BackupFile();
            bf.setName(f.getName());
            bf.setSize((int) (f.length() / 1024L));
            bf.setTime(new Date(f.lastModified()));
            bf.setFiletype(f.getName().substring(f.getName().lastIndexOf(".") + 1));
            bs.add(bf);
        }
        Collections.sort(bs);
        return bs;
    }

    public void backup(String name) {
        String bp = realPath + File.separator + this.backupFile + File.separator + "backup";
        try {
            File bpf = new File(bp);
            bpf.mkdirs();

            MySQLUtil msu = MySQLUtil.getInstance();
            msu.setCfg("database", bp, this.database, this.username, this.password);
            msu.backup();

            for (String f : this.backupFiles) {
                String src = realPath + File.separator + f;
                String dest = bp + f;
                FileUtils.copyDirectory(new File(src), new File(dest));
            }

            TarAndGzipUtil tagu = TarAndGzipUtil.getInstance();
            tagu.tarFile(bp, realPath + File.separator + this.backupFile + File.separator + new Date().getTime() + "_" + name + ".tar");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                FileUtils.deleteDirectory(new File(bp));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void resume(String name) {
        String op = realPath + File.separator + this.backupFile + File.separator + "backup";
        try {
            String fp = realPath + File.separator + this.backupFile + File.separator + name;
            TarAndGzipUtil tagu = TarAndGzipUtil.getInstance();
            tagu.unTarFile(new File(fp), realPath + File.separator + this.backupFile);

            for (String f : this.backupFiles) {
                String src = op + f;
                String dest = realPath + File.separator + f;
                File dfd = new File(dest);
                if (!dfd.exists()) dfd.mkdirs();
                FileUtils.deleteDirectory(dfd);
                FileUtils.copyDirectory(new File(src), dfd);
            }

            MySQLUtil msu = MySQLUtil.getInstance();
            msu.setCfg("database", op, this.database, this.username, this.password);
            msu.resume();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                FileUtils.deleteDirectory(new File(op));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(String name) {
        File f = new File(realPath + File.separator + this.backupFile + File.separator + name);
        f.delete();
    }
}
