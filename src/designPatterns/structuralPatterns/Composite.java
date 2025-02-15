package designPatterns.structuralPatterns;

import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent {
    void showDetails();

    int getSize();
}

class File implements FileSystemComponent {
    private final String name;
    private final int size;

    File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + this.name + " Size: " + this.size + " KB");
    }

    @Override
    public int getSize() {
        return this.size;
    }
}

class Directory implements FileSystemComponent {
    private final String name;
    private final List<FileSystemComponent> components = new ArrayList<>();

    Directory(String name) {
        this.name = name;
    }

    void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) component.showDetails();
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemComponent component : components) totalSize += component.getSize();
        return totalSize;
    }
}

class Composite {
    public static void main(String[] args) {
        // create files
        FileSystemComponent file1 = new File("Document.txt", 100);
        FileSystemComponent file2 = new File("Image.jpg", 200);
        FileSystemComponent file3 = new File("Spreadsheet.xlsx", 150);

        // create directories
        Directory rootDirectory = new Directory("Root");
        Directory documentsDirectory = new Directory("Documents");
        Directory imagesDirectory = new Directory("Images");

        // add files to directories
        documentsDirectory.addComponent(file1);
        documentsDirectory.addComponent(file3);
        imagesDirectory.addComponent(file2);

        // add directories to the root directory
        rootDirectory.addComponent(documentsDirectory);
        rootDirectory.addComponent(imagesDirectory);

        // display the file system hierarchy
        System.out.println("File System Hierarchy");
        rootDirectory.showDetails();

        System.out.println("Total size of the Root Directory: " + rootDirectory.getSize() + " KB");
    }
}
