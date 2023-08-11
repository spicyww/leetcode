import java.util.Arrays;

public class Hotel {
    private Room[][] room;

    public Hotel(){
        this.room = new Room[3][3];
        for(int i = 0; i<3;i++){
            for(int j = 0; j < 3; j++){
                int[] number = new int[]{i, j};
                room[i][j] = new Room(number, "normal", false);
            }
        }
    }

    public Room getRoom(int row, int col){
        return room[row][col];
    }

    public void setRoom(int row, int col, String type, boolean status){
        Room room_set = room[row][col];
        room_set.setStatus(status);
        room_set.setType(type);
    }

    public void book_in(int[] number){
        Room room_in = room[number[0]][number[1]];
        room_in.setStatus(true);
    }

    public void book_out(Room[][] room, int[] number){
        Room room_in = room[number[0]][number[1]];
        room_in.setStatus(false);
    }

    public void show_book(){
        for(Room[] row : room){
            for(Room element : row){
                System.out.println("房间编号：" + Arrays.toString(element.getNum()));
            }
        }
    }

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        int[] number = new int[]{1,1};
        hotel.book_in(number);
        hotel.show_book();
    }
}
