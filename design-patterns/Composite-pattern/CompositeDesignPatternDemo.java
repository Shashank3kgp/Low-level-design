// Beginner-friendly example of the Composite Design Pattern in Java
// This version models a simple file system with files and folders.

import java.util.ArrayList;
import java.util.List;

abstract class FileSystemComponent {
    protected String name;

    public FileSystemComponent(String name) {
        this.name = name;
    }

    public abstract String getName();
    public abstract long getSize();
    public abstract void add(FileSystemComponent component);
    public abstract void remove(FileSystemComponent component);
    public abstract void display(String indent);
}

class File extends FileSystemComponent {
    private final long size;

    public File(String name, long size) {
        super(name);
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("Files cannot contain children.");
    }

    @Override
    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("Files cannot remove children.");
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "File: " + name + " (" + size + " KB)");
    }
}

class Folder extends FileSystemComponent {
    private final List<FileSystemComponent> children = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        long total = 0;
        for (FileSystemComponent child : children) {
            total += child.getSize();
        }
        return total;
    }

    @Override
    public void add(FileSystemComponent component) {
        children.add(component);
    }

    @Override
    public void remove(FileSystemComponent component) {
        children.remove(component);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "Folder: " + name + " (total size: " + getSize() + " KB)");
        for (FileSystemComponent child : children) {
            child.display(indent + "  ");
        }
    }
}

public class CompositeDesignPatternDemo {
    public static void main(String[] args) {
        FileSystemComponent root = new Folder("workspace");
        FileSystemComponent srcFolder = new Folder("src");
        FileSystemComponent docsFolder = new Folder("docs");

        FileSystemComponent appFile = new File("App.java", 30);
        FileSystemComponent readme = new File("README.md", 12);
        FileSystemComponent notes = new File("notes.txt", 8);

        srcFolder.add(appFile);
        docsFolder.add(readme);
        docsFolder.add(notes);

        root.add(srcFolder);
        root.add(docsFolder);

        root.display("");
        System.out.println("\nTotal size of workspace: " + root.getSize() + " KB");
    }
}
