package filesystem;

import java.util.ArrayList;
import java.util.List;

public class Folder extends FileSystemItem {

    private final List<FileSystemItem> children = new ArrayList<>();

    public Folder(String name) {
        super(name, 0);
    }

    @Override
    void ls() {
        System.out.println(name);
        for (FileSystemItem item : children) {
            System.out.println(item.getName());
        }
    }

    @Override
    void openAll() {
        System.out.println(name);
        for (FileSystemItem item : children) {
            item.openAll();
        }
    }

    public void add(FileSystemItem item) {
        children.add(item);
        item.setParent(this);
        updateSizeUpwards(item.getSize());
    }

    @Override
    void delete() {
        double folderSize = size;

        // Remove from parent
        if (parent != null && parent instanceof Folder) {
            ((Folder) parent).removeChild(this);
        }

        // Delete all children recursively
        deleteChildren();

        // Update parent size only its upper parent
        updateSizeUpwards(- folderSize);

        parent = null;
    }


    void removeChild(FileSystemItem item) {
        children.remove(item);
        updateSizeUpwards(-item.getSize());
    }

    private void deleteChildren() {
        for (FileSystemItem item : children) {
            item.delete();
        }
        children.clear();
    }

    // add child size and recursively update parents size.
    private void updateSizeUpwards(double delta) {
        this.size += delta;
        if (parent != null && parent instanceof Folder) {
            ((Folder) parent).updateSizeUpwards(delta);
        }
    }

    @Override
    FileType getFileType() {
        return FileType.FOLDER;
    }
}
