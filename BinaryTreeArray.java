public class BinaryTreeArray{
    int[] data;
    int idxLast;

    public BinaryTreeArray(){
        data = new int[10];
    }

    void populateData(int data[], int idxLast){
        this.data = data;
        this.idxLast = idxLast;
    }

    void traverseIn0rder(int idxStart){
        if(idxStart<=idxLast){
            traverseIn0rder(2*idxStart+1);
            System.out.print(data[idxStart]+" ");
            traverseIn0rder(2*idxStart+2);
        }
    }
}