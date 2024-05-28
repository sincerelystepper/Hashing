import javax.management.monitor.Monitor;

/**
 * Simple hash table implementation using quadratic probing.
 *
 * @author Stephan Jamieson
 * @version 24/4/2015
 */
public class QPHashTable  extends HashTable {
  public Monitorable monitor ; 
  

    /**
     * Create an QPHashTable with DEFAULT_SIZE table.
     */
    public QPHashTable() { 
      super();
      this.monitor = new Monitorable();
    }

    /**
     * Create an QPHashTable with the given default size table.
     */
    public QPHashTable(final int size) { 
      super(size);
      this.monitor = new Monitorable();
    }

    public QPHashTable(Monitorable monitor) {
      super();
      this.monitor = monitor; // initializing the monitor field so to use the instances of monitorable
    }

    /**
     * Find the index for entry: if entry is in the table, then returns its position;
     * if it is not in the table then returns the index of the first free slot.
     * Returns -1 if a slot is not found (such as when the table is full under LP).
     *
     */
    protected int findIndex(String key) {
		// Implement using quadratic probing.

    //monitor.resetProbeCount(); //initialize the probe_count to zero for every method call. 

    int hashCode = hashFunction(key);
    int i = 1;
    int originalIndex = hashCode;
    int probe = 1;

    while (table[hashCode] != null) {    // checking if the slot at index 'hashCode' is occupied by data
      if (table[hashCode].equals(key)) { // checking if that hashCode

        // increment probe for before returning an index, straight up 
        //monitor.incProbeCount(probe);
        return hashCode;
      }
      // performing quadratic probing
      else {  
        hashCode = (hashCode + i*i) % table.length; 
        i++;
        probe++;

        //monitor.incProbeCount(probe);
        if (originalIndex == hashCode) { // an instance when the table has exhausted iterating the whole table, and is full.  

          return -1; 
        }

        // increment probes for unsuccesful probes
        //monitor.incProbeCount(probe);
      }
    }
    // increment probe for searches of empty slot
    //monitor.incProbeCount(probe);
    return hashCode;  // returns the slot in the hashtable

       }
 }