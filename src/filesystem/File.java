package filesystem;

public class File extends FileSystemItem {

    public File(String name, double size) {
        super(name, size);
    }

    @Override
    void ls() {
        System.out.println(name);
    }

    @Override
    void openAll() {
        System.out.println(name);
    }

    @Override
    FileType getFileType() {
        return FileType.FILE;
    }

    @Override
    void delete() {
        if (parent != null && parent instanceof Folder) {
            ((Folder) parent).removeChild(this);
        }
        parent = null;
    }
}
