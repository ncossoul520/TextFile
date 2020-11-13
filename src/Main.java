public class Main {
    public static void main(String[] args) {
        TextFile tf = new TextFile("file1.txt");

        tf.Write("Hello there\nHow are you?");
        System.out.println( tf.Read() );
    }
}
