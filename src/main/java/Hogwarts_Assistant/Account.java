import Hogwarts_Assistant.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import java.io.IOException;
import java.util.*;
public class Account extends Excel implements AccountManagement {
    private String username;
    // TODO: Passwords should hashed
    private String password;
    private UUID accountID;
    static private ArrayList<String> pass=new ArrayList<>();
    static private ArrayList<String> user=new ArrayList<>();
    private String response;
    Scanner myObj = new Scanner(System.in);



    @Override
    public boolean validatePassword(String enteredPassword) {
        //TODO
        if (pass.contains(enteredPassword)){
            System.out.println("validated!");
            return true;
        } else  {
            System.out.println("Password not validated or doesn't exit!\n" +
                    "first verify it or creat a neon");
            return false;
        }

    }

    @Override
    public void changePassword(String newPassword) {
        //TODO
        System.out.println("Password:");
        System.out.println("Do you have any password?(response with \"Y\" " +
                "or \"N\")");
        String Y_N=myObj.next();
        if (Objects.equals(Y_N, "Y")){
            System.out.println("Enter your previous password:");
            response=myObj.next();
            if (validatePassword(response)){
                int i=pass.indexOf(response);
//                pass.set(i,newPassword);
//                try {
//                    WriteExcel("Pass_User",i+1,0,newPassword);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
            }
        }
        if (Objects.equals(Y_N, "N")){
            pass.add(newPassword);
//            try {
//                WriteExcel("Pass_User",-1,0,newPassword);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }

        }
        else {System.out.println("didnt understand!\nThe operation will restart...");
            changePassword(newPassword);}

        System.out.println(pass);
    }

    @Override
    public void changeUsername(String newUsername) {
        //TODO
        System.out.println("Username:");
        System.out.println("Do you have any Password?(response with \"Y\" " +
                "or \"N\")");
        String Y_N=myObj.next();
        if (Objects.equals(Y_N, "Y")){
            System.out.println("Enter your Password:");
            response=myObj.next();
            if (validatePassword(response)==true){
                int i=pass.indexOf(response);
                if (user==null ||i==user.size()){
                    user.add(i,newUsername);
                    position();

                }
                else user.set(i,newUsername);
            }
            else System.out.println("there is no such Password");
        }
        if (Objects.equals(Y_N, "N")){
            System.out.println("first,please creat a password");
        }
        else {System.out.println("didnt understand!\nThe operation will restart...");
        changeUsername(newUsername);}

        System.out.println(user);
    }
    public void position(){
        String response;
        String response2;
        System.out.println("Please fill up these questions concerning to your profile:\ndefine " +
                "your position:{Assistant:1,Teacher:2,Student:3}");
        response=myObj.next();
        System.out.println("Your identification(Name & Lastname):");
        response2=myObj.next();
        switch (response){
            case "1":Hogwarts.viewAllAssistant(response2);
            case "2":Hogwarts.viewAllTeachers(response2);
            case "3":Hogwarts.viewAllStudents(response2);

        }
        System.out.println("Thanks");



    }
}
