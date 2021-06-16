import java.awt.*;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private boolean newUser = true;
    private int countStr = 0;
    private boolean isWithDate = true;

    private List<User> userList = new ArrayList<>();

    public void start() throws URISyntaxException {

        File file = null;

        URL resource = getClass().getClassLoader().getResource("users.txt");
        if (resource == null) {
            throw new IllegalArgumentException("file not found!");
        } else {

            file = new File(resource.toURI());
            System.out.println(file.getAbsoluteFile());
        }

        try (   FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr)) {
                String line = null;
                while ((line = br.readLine()) != null ) {
                    parse(line);
                }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        Collections.sort(userList);
        System.out.println(userList);


        int aaa = 1;

    }

    private void parse(String line) {
        User user = null;
        if (countStr == 0) {
            user = new User();
            userList.add(user);
        } else {
            user = userList.get(userList.size() - 1);
        }
        countStr++;
        switch (countStr) {
            case 1:
                user.setFamily(line);
                break;
            case 2:
                user.setName(line);
                break;
            case 3:
                user.setSecondName(line);
                break;
            case 4:
                if(isInteger(line)) {
                    user.setAge(Integer.parseInt(line));
                } else {
                    countStr++;
                }
                break;
            case 5:
                user.setPassport(line);
                countStr = 0;
                break;
        }
    }

    public static void main(String[] args) throws URISyntaxException {
        //System.out.println("Hello world");

        Main m = new Main();
        m.start();


    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

}
