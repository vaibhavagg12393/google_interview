/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vaibhavaggarwal
 */
public class Google_question2 {

    public static void main(String[] args) {
        String a = "dir1\n dit11\n dir12\n  p.jpeg\n  dir121\n  fire.txt\ndir2\n file.gif";
        System.out.println(solution(a));
    }

    public static int solution(String str) {
        String lines[] = str.split("\n");
        int longest = Integer.MIN_VALUE;
        int previousIndent = -1;
        String basePath = null;
        for (int i = 0; i < lines.length; i++) {
            if (basePath == null) {
                basePath = "/" + lines[i];
                previousIndent = 0;
                continue;
            }
            int indent = getIndent(lines[i]);
            if (indent > previousIndent) {
                if (isFile(lines[i])) {
                    if (isImageFile(lines[i])) {
                        int sumPath = basePath.length();
                        if (sumPath > longest) {
                            longest = sumPath;
                        }
                    }
                } else {
                    basePath += "/" + lines[i];
                }
                previousIndent = indent;
            } else {
                int diff = previousIndent - indent+1;
                for (int j = 0; j < diff; j++) {
                    String contents[] = basePath.split("/");
                    String newBasePath = "";
                    for (int k = 0; k < contents.length - 1; k++) {
                        newBasePath += contents[k];
                    }
                    basePath = newBasePath;
                }
                if (isFile(lines[i])) {
                    if (isImageFile(lines[i])) {
                        int sumPath = basePath.length();
                        if (sumPath > longest) {
                            longest = sumPath;
                        }
                    }
                } else {
                    basePath += "/" + lines[i];
                }
                previousIndent = indent;
            }
        }
        return longest==Integer.MIN_VALUE? 0:longest;
    }

    public static boolean isImageFile(String str) {
        String fileVals[] = str.split("[.]");
        String extension = fileVals[fileVals.length - 1];
        if (extension.equalsIgnoreCase("jpeg") || extension.equalsIgnoreCase("gif") || extension.equalsIgnoreCase("png")) {
            return true;
        }
        return false;
    }

    public static boolean isFile(String str) {
        return str.contains(".");
    }

    public static int getIndent(String str) {
        int indents = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                indents++;
            } else {
                break;
            }
        }
        return indents;
    }

}



