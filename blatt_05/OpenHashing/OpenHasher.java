package OpenHashing;
import util.*; // Make sure that we are able to use the list that we created, while
                // still maintaining order
/**
 * An OpenHasher contains an array of Lists, in which Objects are sorted
 * according to their Hash Codes.
 */
public class OpenHasher implements HashSet {
    /**
     * The Array of lists, where our Lists with the HashCodes will be saved
     */
    private GenericList[] hashList;
    private int magicNumber;

    /**
     * The Default constructor creates an array of length 10
     */
    public OpenHasher() {
        this( 10 );
    }

    /**
     * This picky constructor allows for the creation of an array of a preffered length.
     * The Lists themselves will be initialised here as well
     */
    public OpenHasher( int sayTheWord ) {
        this.magicNumber = sayTheWord;
        this.hashList = new GenericList[ magicNumber ];
        for( int i = 0; i < hashList.length; i++ ) {
            hashList[i] = new GenericList<Object>();
        }
    }

	@Override
	public boolean contains(Object o) {
        int index = o.hashCode() % magicNumber;
        while( !hashList[index].endpos() ) {
            if( hashList[index].elem().equals(o) ) {
                hashList[index].reset();
                return true;
            }
            hashList[index].advance();
        }
        hashList[index].reset();
		return false;
	}

	@Override
	public boolean insert(Object o) {
        int index = o.hashCode() % magicNumber;
        if( !this.contains(o) ) {
            hashList[index].add( o );
            return true;
        }
		return false;
	}

	@Override
	public boolean delete(Object o) {
        int index = o.hashCode() % magicNumber;
        if( this.contains( o ) ) {
            while( !hashList[index].endpos() ) {
                if( hashList[index].elem().equals( 0 ) ) {
                    hashList[index].delete();
                    hashList[index].reset();
                    return true;
                }
                hashList[index].advance();
            }
        }
        hashList[index].reset();
		return false;
	}
	
}