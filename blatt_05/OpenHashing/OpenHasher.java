package OpenHashing;
import util.*; // Make sure that we are able to use the list that we created, while
                // still maintaining order
/**
 * An OpenHasher contains an array of Lists, in which Objects are sorted
 * according to their Hash Codes.
 */
public class OpenHasher<T> implements HashFunction, HashSet {

    private GenericList<T>[] hashList;
	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public boolean insert(Object o) {
		return false;
	}

	@Override
	public boolean delete(Object o) {
		return false;
	}

	@Override
	public boolean equals(Object o1, Object o2) {
		return false;
	}

	@Override
	public int hashCode(Object o) {
		return 0;
	}
}