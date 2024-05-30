public class BinaryTreeArrayMain{
    public static void main(String[] args){
        BinaryTreeArray bta = new BinaryTreeArray();
        int [] data = {6,4,3,5,7,9,0,0,0};
        int idxLast = 6;
        bta.populateData(data, idxLast);
        bta.traverseIn0rder(0);
    }
}