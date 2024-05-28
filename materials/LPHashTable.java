import java.util.List;
/**
 * Simple hash table implementation using linear probing.
 *
 * @author Stephan Jamieson
 * @version 24/4/2015
 */
public class LPHashTable extends HashTable {

    /**2
     * Create an LPHashTable with DEFAULT_SIZE table.
     */
    public LPHashTable() { super(); }

    /**
     * Create an LPHashTable with the given default size table.
     */
    public LPHashTable(final int size) { super(size); }

    /**
     * Find the index for entry: if entry is in the table, then returns its position;
     * if it is not in the table then returns the index of the first free slot.
     * Returns -1 if a slot is not found (such as when the table is full under LP).
     *
     */
    protected int findIndex(String key) {
		// Implement using linear probing.
    int hashCode = hashFunction(key); // finding the index of the given key
    int index = hashCode;
    int step = 1;
    int originalIndex = index;

    while (table[index] != null){

      // returns the index of the direct input key parameter
      if (table[index].equals(key)) {
        return index;
      }

      index += step;
      step++;

      // returns the -1 if hash is full
      if (index == originalIndex) {
        return -1;
      }
    }

    // return the slot in the hashtable
    return index; 
    }
}

