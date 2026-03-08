package filesystem;

public abstract class FileSystemItem {

    protected String name;
    protected double size;
    protected FileSystemItem parent;

    FileSystemItem(String name, double size) {
        this.name = name;
        this.size = size;
    }

    abstract void ls();
    abstract void openAll();
    abstract FileType getFileType();
    abstract void delete();

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    public FileSystemItem getParent() {
        return parent;
    }

    public void setParent(FileSystemItem parent) {
        this.parent = parent;
    }
}
