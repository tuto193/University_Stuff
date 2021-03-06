package Searching;

import java.io.File;
import java.util.regex.*;

/**
 * @author Mathias Menninghaus (mathias.mennighaus@uos.de)... modified by Carlos A. Parra
 */
public class List {
   public static void main(String[] args) {

      /*
       * flags for the options
       */
      boolean recursive = false;
      /*
       * determine whether all arguments are read or not
       */
      boolean argumentsRead = false;

      int i = 0;
      String pattern = ".*";
      while (!argumentsRead && i < args.length) {

         /*
          * read out the arguments
          */
         switch (args[i]) {
            case "-r":
               recursive = true;
               i++;
               break;
            
            case "-p":
              // Should the arguments not suffice the
              // functions of the program
              if( i + 1 > args.length ) {
                throw new RuntimeException( "No pattern given. A pattern musst be"
                		+ "specified after [-p]" );
              }             
              pattern = args[i+1];
              i += 2;
              break;
            default:
            /*
             * arguments must be set at the beginning. Every String which isn't
             * an argument, must be a path
             */
               argumentsRead = true;
               break;
         }
      }

      String dir;
      // dir is either a specific (sub)folder or the whole containing folder
      if (i == args.length) {
         dir = ".";
      } else {
         dir = args[i];
      }

      /*
       * list all files that match the pattern.
       * List all files, if no pattern was specified
       */

      System.out.println("Listing " + dir);
      File f = new File(dir);
      if (!f.exists()) {
         System.out.println("...does not exist");
      } else {
         new FileSystem(f).accept(new DoList(f, recursive, pattern));
      }
   }

   private static class DoList implements FileVisitor {
      private StringBuffer indent = new StringBuffer();

      private boolean recursive;
      private File root;
      private Pattern PATTERN;
      private Matcher MATCHER;

      private DoList(File root, boolean recursive) {
        this( root, recursive, "." );
      }

      private DoList( File root, boolean recursive, String pattern ) {
        this.recursive = recursive;
        this.root = root;
        this.PATTERN = Pattern.compile(pattern);
      }

      @Override
      public FileVisitResult postVisitDirectory(File dir) {
    	  // Make sure that we delete the directory end and carry on with the rest
    	  String[] toSplit = indent.toString().split("/");
    	  String newIndent = "";
    	  for( int i = 0; i < toSplit.length - 1; i++ ) {
    		  newIndent += toSplit[i] + "/";
    	  }
    	  indent = indent.delete(0, indent.length() );
         indent.append(newIndent);
         return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult preVisitDirectory(File dir) {
        // This line right underneath musst be commented out on the final version
         //System.out.println(indent + dir.getName());

         if (recursive || this.root.equals(dir)) {
            indent.append( dir.getName() + "/" );
            return FileVisitResult.CONTINUE;
         } else {
            return FileVisitResult.SKIP_SUBTREE;
         }
      }

      @Override
      public FileVisitResult visitFailed(File file) {
         System.out.print(indent);
         System.out.println(file.getName() + " (unreadable) ");
         return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult visitFile(File file) {

        // Only files that actually match the regex will be seen
         MATCHER = PATTERN.matcher( file.getName() );
         if( MATCHER.find() ) {

          System.out.print(indent);

          System.out.println(file.getName());
         }

         return FileVisitResult.CONTINUE;
      }
   }

}
