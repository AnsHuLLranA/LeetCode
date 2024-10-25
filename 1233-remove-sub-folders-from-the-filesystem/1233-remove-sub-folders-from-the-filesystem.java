import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        
        List<String> result = new ArrayList<>();
        String previousFolder = null;
        
        for (String currentFolder : folder) {
            if (previousFolder == null || !currentFolder.startsWith(previousFolder + "/")) {
                result.add(currentFolder);        
                
                previousFolder = currentFolder;   
                
            }
        }
        
        return result;
    }
}
