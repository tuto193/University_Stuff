package Searching;

import java.io.File;

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
      String pattern = ".";
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
              // Should the arguments not sufice the
              // functions of the program
              if( i + 2 > args.length ) {
                throw new RuntimeException( "The amount of arguments given, doesn't match" );
              }             
              pattern = args[i+1];
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
      private String PATTERN;

      private DoList(File root, boolean recursive) {
        this( root, recursive, "." );
      }

      private DoList( File root, boolean recursive, String pattern ) {
        this.recursive = recursive;
        this.root = root;
        this.PATTERN = pattern;
      }

      @Override
      public FileVisitResult postVisitDirectory(File dir) {
         indent = indent.delete(indent.length() - 2, indent.length());
         return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult preVisitDirectory(File dir) {
        if( dir.getName().matches(PATTERN) && dir.isFile() ) {
          System.out.println(indent + "+ " + dir.getName());
        }

         if (recursive || this.root.equals(dir)) {
            indent.append("| ");
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

         System.out.print(indent);

         System.out.println(file.getName());

         return FileVisitResult.CONTINUE;
      }
   }

}
