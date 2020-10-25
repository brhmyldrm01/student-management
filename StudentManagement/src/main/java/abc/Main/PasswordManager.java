package abc.Main;

public class PasswordManager {
        int DBPassword;
        public PasswordManager(char[] password){
            this.DBPassword=Convert(password);
        }

    public static int Convert(char[] password){
        int DBpass=0;
        int ascii = 0;
        for(int i=0;i<password.length;i++){
            char character=password[i];
             ascii=(int)character;
            DBpass+=ascii;
        }
        return DBpass;

    }




}
