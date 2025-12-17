package filesystem2;

import filesystem.FileType;
import java.util.List;

public abstract class FileSystemItem {

    protected String name;
    protected double size;
    protected FileSystemItem parent;
    protected FileType type;

    FileSystemItem(String name, Double size, FileType type) {
        this.name = name;
        this.size = size;
        this.type = type;
    }

    abstract void ls();
    abstract void openAll(FileSystemItem fileItem);
    abstract void addFileItem(FileSystemItem item);
    abstract void deleteFileItem();
    abstract String getName();
    abstract double getSize();
    abstract void updateSize(double delta);
    abstract FileType getFileType();
    abstract FileSystemItem getParent();
    abstract void setParent(FileSystemItem parent);
    abstract List<FileSystemItem> getChildren();
}
