import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class  GrepTool {

    public String grep(String pattern, List<String> flags, List<String> files) {
        StringBuilder matches = new StringBuilder();
        String line;
        final String pat = getPattern(pattern,!flags.contains("-i"),flags.contains("-v"),flags.contains("-x"));
        boolean multFiles = files.size() > 1;
        boolean onlyFiles = flags.contains("-l");
        for (String fileName : files) {
            int lineNumber = 1;
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                line = reader.readLine();
                while (line != null) {
                    if (line.matches(pat)){
                        if (multFiles || onlyFiles) {
                            matches.append(fileName);
                            if (onlyFiles) {
                                matches.append('\n');
                                break;
                            } else {
                                matches.append(':');
                            }
                        }
                        if (flags.contains("-n")) {
                            matches.append(lineNumber).append(':');
                        }
                        matches.append(line).append('\n');
                    }
                    line = reader.readLine();
                    lineNumber++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return matches.toString().trim();
    }

    private String getPattern(String pattern, boolean caseSensitive, boolean inverted, boolean wholeLine) {
        String pat = ".*" + pattern + ".*";
        if (inverted && wholeLine) {
            pat = "^(?!" + pattern + "$).*";
        } else if (inverted) {
            pat = "^((?!"+ pattern + ").)*$";
        } else if (wholeLine) {
            pat = pattern;
        }
        return caseSensitive ? pat : "(?i)" + pat;
    }
}
