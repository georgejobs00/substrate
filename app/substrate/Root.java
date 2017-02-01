package projekt.substrate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class Root {
    public static SU su;

    public static String runCommand(String command) {
        return Root.getSU().runCommand(command);
    }

    private static SU getSU() {
        if (su == null) {
            su = new SU();
        } else if (su.closed || su.denied) {
            su = new SU();
        }
        return su;
    }

    private static class SU {
        private Process process;
        private BufferedWriter bufferedWriter;
        private BufferedReader bufferedReader;
        private boolean closed;
        private boolean denied;
        private boolean firstTry;

        SU() {
            try {
                this.firstTry = true;
                this.process = Runtime.getRuntime().exec("su");
                this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.process.getOutputStream()));
                this.bufferedReader = new BufferedReader(new InputStreamReader(this.process.getInputStream()));
            }
            catch (IOException e) {
                this.denied = true;
                this.closed = true;
            }
        }

        public synchronized String runCommand(String command) {
            try {
                int i;
                StringBuilder sb = new StringBuilder();
                String callback = "/shellCallback/";
                this.bufferedWriter.write(command + "\necho " + callback + "\n");
                this.bufferedWriter.flush();
                char[] buffer = new char[256];
                do {
                    sb.append(buffer, 0, this.bufferedReader.read(buffer));
                } while ((i = sb.indexOf(callback)) <= -1);
                sb.delete(i, i + callback.length());
                this.firstTry = false;
                return sb.toString().trim();
            }
            catch (IOException e) {
                this.closed = true;
                e.printStackTrace();
                if (this.firstTry) {
                    this.denied = true;
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                this.denied = true;
            }
            catch (Exception e) {
                e.printStackTrace();
                this.denied = true;
            }
            return null;
        }

        public void close() {
            try {
                this.bufferedWriter.write("exit\n");
                this.bufferedWriter.flush();
                this.process.waitFor();
                this.closed = true;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}