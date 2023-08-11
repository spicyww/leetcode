public class Room {
    private int[] num;
    private boolean status;
    // normal good
    private String type;

    public Room(int[] num, String type, boolean status){
        this.num = num;
        this.type = type;
        this.status = status;
    }

    public Room(){
        this.num = new int[]{0,0};
        this.type = "normal";
        this.status = false;
    }

    public int[] getNum() {
        return num;
    }

    public void setNum(int[] num) {
        this.num = num;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
