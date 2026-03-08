package filesystem2;

import filesystem.FileType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileClass extends FileSystemItem {

    private final List<FileSystemItem> children;

    FileClass(String name, Double size, FileType type) {
        super(name, size, type);
        this.children = (type == FileType.FOLDER) ? new ArrayList<>() : Collections.emptyList();
    }

    @Override
    void ls() {
        System.out.println(name);
        if (type == FileType.FOLDER) {
            for (FileSystemItem item : children) {
                System.out.println(item.getName());
            }
        }
    }

    @Override
    void openAll(FileSystemItem fileItem) {
        System.out.println(fileItem.getName());

        if (fileItem.getFileType() == FileType.FOLDER) {
            for (FileSystemItem item : fileItem.getChildren()) {
                openAll(item);
            }
        }
    }

    @Override
    void addFileItem(FileSystemItem item) {

        // NOT a folder → silently ignore
        if (this.type != FileType.FOLDER) {
            return;
        }

        children.add(item);
        item.setParent(this);

        updateSize(item.getSize());

        FileSystemItem current = parent;
        while (current != null) {
            current.updateSize(item.getSize());
            current = current.getParent();
        }
    }

    @Override
    void deleteFileItem() {

        double itemSize = size;

        if (parent != null && parent.getFileType() == FileType.FOLDER) {
            parent.getChildren().remove(this);
        }

        FileSystemItem current = parent;
        while (current != null) {
            current.updateSize(-itemSize);
            current = current.getParent();
        }

        if (type == FileType.FOLDER) {
            children.clear();
        }

        parent = null;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    double getSize() {
        return size;
    }

    @Override
    void updateSize(double delta) {
        size += delta;
    }

    @Override
    FileType getFileType() {
        return type;
    }

    @Override
    FileSystemItem getParent() {
        return parent;
    }

    @Override
    void setParent(FileSystemItem parent) {
        this.parent = parent;
    }

    @Override
    List<FileSystemItem> getChildren() {
        return children;
    }
}
