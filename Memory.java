import java.util.Arrays;

public class Memory {
	private int Size = 2048;
    public int[] memory = new int[this.Size];
    	public  void insertX(int value, int index)
{
   
    	        this.memory[index] = value;
	            System.out.println("Storing value " +value+" index "+index );

}
    

    public int getValue(int index) {
        System.out.println("loading value " + this.memory[index] );

        return this.memory[index] ;

    }
}