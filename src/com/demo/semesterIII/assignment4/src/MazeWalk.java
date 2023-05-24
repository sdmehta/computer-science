package com.demo.semesterIII.assignment4.src;

import BasicIO.ASCIIDataFile;
import BasicIO.ASCIIOutputFile;

public class MazeWalk {
    private static boolean findPath(Character[][] maze, int x, int y) {
        if(maze[x][y] == 'E') {
            System.out.println("Crush found at: (" + x +","  + y + ")");
            return true;
        }

        if(maze[x][y] == '#' || maze[x][y] == 'v' || maze[x][y] == '>'
                || maze[x][y] == '^' || maze[x][y] == '<' || maze[x][y] == '.')
            return false;

        maze[x][y] = 'v';
        if(findPath(maze, x + 1, y))  return true;

        maze[x][y] = '>';
        if(findPath(maze, x, y + 1))  return true;

        maze[x][y] = '^';
        if(findPath(maze, x - 1, y))  return true;

        maze[x][y] = '<';
        if(findPath(maze, x , y - 1))  return true;

        maze[x][y] = '.';

        return false;
    }

    public static void main(String[] args) {
        ASCIIDataFile dataFile = new ASCIIDataFile();
        ASCIIOutputFile outputFile =  new ASCIIOutputFile();
        int xLength = dataFile.readInt();
        System.out.println(xLength);
        int yLength = dataFile.readInt();
        Character[][] maze = new Character[xLength][yLength];

        for (int x = 0; x < xLength; x++){
            for (int y = 0; y < yLength; y++) {
                maze[x][y] = dataFile.readC();
            }
            dataFile.readLine();
        }

        maze[1][1] = 'S';
        maze[50][25] = 'E';
        findPath(maze, 1, 1);

        for (int x = 0; x < xLength; x++){
            for (int y = 0; y < yLength; y++) {
                outputFile.writeC(maze[x][y]);
            }
            outputFile.writeLine("");
        }
    }
}