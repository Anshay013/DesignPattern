package filesystem2;

import filesystem.FileType;

public class FileSystemDriver {

    public static void main(String[] args) {

        FileSystemItem root =
                new FileClass("root", 0.0, FileType.FOLDER);

        FileSystemItem docs =
                new FileClass("docs", 0.0, FileType.FOLDER);

        FileSystemItem images =
                new FileClass("images", 0.0, FileType.FOLDER);

        FileSystemItem readme =
                new FileClass("README.md", 5.0, FileType.FILE);

        root.addFileItem(docs);
        root.addFileItem(images);
        root.addFileItem(readme);

        FileSystemItem resume =
                new FileClass("resume.pdf", 20.0, FileType.FILE);

        FileSystemItem notes =
                new FileClass("notes.txt", 10.0, FileType.FILE);

        FileSystemItem vacation =
                new FileClass("vacation", 0.0, FileType.FOLDER);

        docs.addFileItem(resume);
        docs.addFileItem(notes);
        images.addFileItem(vacation);

        resume.addFileItem(
                new FileClass("illegal.txt", 5.0, FileType.FILE)
        );

        FileSystemItem img1 =
                new FileClass("img1.jpg", 8.0, FileType.FILE);

        FileSystemItem img2 =
                new FileClass("img2.jpg", 12.0, FileType.FILE);

        vacation.addFileItem(img1);
        vacation.addFileItem(img2);

        root.ls();
        root.openAll(root);

        System.out.println(root.getSize());   //  55

        notes.deleteFileItem();
        System.out.println(root.getSize());   //  45

        images.deleteFileItem();
        System.out.println(root.getSize());   //  25

        root.ls();
        root.openAll(root);

        readme.deleteFileItem();
        resume.deleteFileItem();
        docs.deleteFileItem();

        System.out.println(root.getSize());   //  0
    }
}
