import java.io.File

class Directory (var name: String, var level: Int, var files: MutableList<FileCustom>, var directories: MutableList<Directory>, var parent: String) {
    var currentLevel = 0
    var currentDirectoryName = ""
    var currentDirectoryObj : Directory = this

    fun getTotalSize() {

    }

    fun addDirectory(dir: Directory) {
        directories.add(dir)
    }

    fun addFile(f: FileCustom) {
        files.add(f)
    }

    fun changeDirectory(dir: String) {
        if (dir != currentDirectoryName && dir != "..") {
            currentDirectoryName = dir
            currentLevel++
            currentDirectoryObj = findSubDirectory(currentDirectoryObj, dir)
        } else if (dir == "..") {
            currentLevel--
            currentDirectoryName = ""
        }
    }

    fun checkDirectory(d: Directory) {
        if (!directories.contains(d) && currentLevel == 0) {
            addDirectory(d)
        } else {
            for (dir in directories) {
                if (!dir.directories.contains(d) && dir.level == currentLevel && currentDirectoryName == dir.name) {
                    dir.addDirectory(d)
                }
            }
        }
    }

    fun checkFile(f: FileCustom) {
        if (!files.contains(f) && currentLevel == 0 && currentDirectoryName == name) {
            addFile(f)
        } else {
            val dir = directories
            for (x in 0..currentLevel) {
                val subdir = dir[x]

            }
            for (dir in directories) {
                if (!dir.files.contains(f) && dir.level == currentLevel && currentDirectoryName == dir.name) {
                    dir.addFile(f)
                }
            }
        }
    }

    fun printTree() {
        println(name + "(dir)")
        for (file in files) {
            for (space in 0 .. file.level) {
                print(' ')
            }
            print(file.name + "(file, size=" + file.size + ")\n")
        }
        for (dir in directories) {
            dir.printTree()
        }
    }

    fun findSubDirectory(dir: Directory, n: String): Directory {
        var isFound = false
        for (d in dir.directories) {
            if (d.name == n) {
                isFound = true
                return d
            }
        }
        findSubDirectory()
    }
}

class FileCustom (var name: String, var size: Int, var level: Int)

fun main(args: Array<String>) {
    var input = File("./2022/Day 7/test").readLines()
    var drive = Directory("/", 0, mutableListOf(), mutableListOf(), "")
    for (line in input) {
        if (!line.contains("$")) {
            val lineArr = line.split(' ')
            if (line.contains("dir ")) {
                val directory = Directory(lineArr[lineArr.lastIndex], drive.currentLevel+1, mutableListOf(), mutableListOf(), drive.currentDirectoryName)
                drive.checkDirectory(directory)
            } else {
                val file = FileCustom(lineArr[lineArr.lastIndex], Integer.parseInt(lineArr[0]), drive.currentLevel+1)
                drive.checkFile(file)
            }
        } else if (line.contains("cd")) {
            val lineArr = line.split(' ')
            drive.changeDirectory(lineArr[lineArr.lastIndex])
//            println(root.currentDirectory)
//            println(root.currentLevel)
        }
    }
    drive.printTree()
}