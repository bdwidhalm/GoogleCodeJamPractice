
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProblemTemplete {
  public static void main(String[] args) {
    try {
      String inputFileName = "A-small-practice";
      String outputFileName = inputFileName + ".out";

      BufferedReader reader = new BufferedReader(new FileReader(new File(inputFileName + ".in")));
      BufferedWriter writer = new BufferedWriter(new FileWriter(new File(outputFileName)));

      String line = reader.readLine();
      int numberOfCase = Integer.valueOf(line);
      for (int i = 0; i < numberOfCase; i++) {
        String[] infos = reader.readLine().split("[ ]");
        int rowCnt = Integer.valueOf(infos[0]);
        int wCount = Integer.valueOf(infos[1]);
        int[][] map = new int[102][102];
        for (int j = 0; j < 102; j++) {
          map[0][j] = 0;
          map[j][0] = 0;
          map[101][j] = 0;
          map[j][101] = 0;
        }
        int colCnt = 0;
        for (int j = 0; j < rowCnt; j++) {
          line = reader.readLine();
          if (colCnt == 0) {
            colCnt = line.length();
          }

          line = line.replaceAll("[.]", "");

          while (line.length() < colCnt) {
            line = "." + line;
          }

          for (int k = 0; k < colCnt; k++) {
            char curChar = line.charAt(k);
            if (curChar == '.')
              map[j + 1][k + 1] = 0;
            else if (curChar == 'R')
              map[j + 1][k + 1] = 1;
            else if (curChar == 'B')
              map[j + 1][k + 1] = 2;
          }
        }

//        for (int j = 1 ; j < rowCnt + 1; j++) {
//          for (int k = 1; k < colCnt + 1; k++) {
//            System.out.print(map[j][k]);
//          }
//          System.out.println();
//        }

        int winner = getWinner(map, wCount, rowCnt, colCnt);

        //Print Answer
        System.out.println("Case #" + (i + 1) + ": ");
        writer.write("Case #" + (i + 1) + ": ");

        if (winner == 3) {
          System.out.println("Both");
          writer.write("Both\n");
        } else if (winner == 2) {
          System.out.println("Blue");
          writer.write("Blue\n");
        } else if (winner == 1) {
          System.out.println("Red");
          writer.write("Red\n");
        } else if (winner == 0) {
          System.out.println("Neither");
          writer.write("Neither\n");
        }
      }

      writer.flush();
      writer.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static int getWinner(int[][] map, int wCount, int rowCnt, int colCnt) {
    boolean redSuccess = false;
    boolean blueSuccess = false;
    for (int i = 1; i < rowCnt + 1; i++) {
      for (int j = 1; j < colCnt + 1; j++) {
        if (map[i][j] != 0) {
          int curCol = map[i][j];
          boolean isSuccess = true;
          //check left
          for (int k = 0; k < wCount; k++) {
            if (map[i][j + k] != curCol) {
              isSuccess = false;
              break;
            }
          }
          if (isSuccess) {
            if (curCol == 1) {
              redSuccess = true;
            } else {
              blueSuccess = true;
            }
          }

          isSuccess = true;
          //check down
          for (int k = 0; k < wCount; k++) {
            if (map[i + k][j] != curCol) {
              isSuccess = false;
              break;
            }
          }
          if (isSuccess) {
            if (curCol == 1) {
              redSuccess = true;
            } else {
              blueSuccess = true;
            }
          }

          isSuccess = true;
          //check diagnol
          for (int k = 0; k < wCount; k++) {
            if (map[i + k][j + k] != curCol) {
              isSuccess = false;
              break;
            }
          }
          if (isSuccess) {
            if (curCol == 1) {
              redSuccess = true;
            } else {
              blueSuccess = true;
            }
          }

          isSuccess = true;
          //check diagnol
          for (int k = 0; k < wCount; k++) {
            if (map[i + k][j - k] != curCol) {
              isSuccess = false;
              break;
            }
          }
          if (isSuccess) {
            if (curCol == 1) {
              redSuccess = true;
            } else {
              blueSuccess = true;
            }
          }
          if (redSuccess && blueSuccess)
            break;
        }
      }
    }

    if (redSuccess && blueSuccess)
      return 3;

    if (blueSuccess)
      return 2;

    if (redSuccess)
      return 1;

    return 0;
  }
}
