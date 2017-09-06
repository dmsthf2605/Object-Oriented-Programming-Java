import java.io.*;

public class What {
    public static void main(String[] args){
        File file = new File(args[0]);
        String[] files = file.list(new FilenameFilter() {

            public boolean accept(File dir, String name) {
                if(name.toLowerCase().endsWith(args[1]))
                    return true;
                else
                    return false;
            }
        });
        if (files != null)
            for(String f:files){
                System.out.println(f);
            }
    }
}