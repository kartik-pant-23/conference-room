package conference_room;

import conference_room.models.Booking;
import conference_room.models.Building;
import conference_room.models.Room;
import conference_room.models.User;
import conference_room.repository.BookingRepositoryImpl;
import conference_room.repository.BuildingRepositoryImpl;
import conference_room.repository.RoomRepositoryImpl;
import conference_room.repository.UserRepositoryImpl;
import conference_room.services.BuildingServices;
import conference_room.services.RoomServices;
import conference_room.services.UserServices;

public class App {

    private static final UserServices userServices = new UserServices(new UserRepositoryImpl());
    private static final RoomServices roomServices = new RoomServices(new RoomRepositoryImpl(),
            new BookingRepositoryImpl(), userServices);
    private static final BuildingServices buildingServices = new BuildingServices(new BuildingRepositoryImpl(),
            roomServices);
    private static User user;

    interface CustomFunction {
        void run() throws Exception;
    }

    private static void runMethodWithTryCatch(CustomFunction someFunction) {
        try {
            someFunction.run();
        } catch (Exception e) {
            System.out.println("message: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // adding a user
        System.out.println("--- CREATE_USER ---");
        runMethodWithTryCatch(() -> {
            user = userServices.createUser();
            System.out.println("created: " + user);
        });

        // adding a building
        System.out.println("--- ADD_BUILDING b1 ---");
        runMethodWithTryCatch(() -> {
            Building building = buildingServices.addBuilding("b1");
            System.out.println("created: " + building);
        });

        // trying to add building b1 again
        System.out.println("--- ADD_BUILDING b1 ---");
        runMethodWithTryCatch(() -> {
            Building building = buildingServices.addBuilding("b1");
            System.out.println("created: " + building);
        });

        // adding floors to building b1
        System.out.println("--- ADD_FLOOR 1 b1 ---");
        runMethodWithTryCatch(() -> {
            buildingServices.addFloor("b1", 1);
            System.out.println(buildingServices.getBuilding("b1"));
        });

        // adding floors to building b2
        System.out.println("--- ADD_FLOOR 1 b2 ---");
        runMethodWithTryCatch(() -> {
            buildingServices.addFloor("b2", 1);
            System.out.println(buildingServices.getBuilding("b2"));
        });

        // adding conference room to building b1
        System.out.println("--- ADD_CONFROOM c1 1 b1 ---");
        runMethodWithTryCatch(() -> {
            Building building = buildingServices.getBuilding("b1");
            Room room = roomServices.addRoom("c1", 1, building);
            System.out.println("created: " + room);
        });

        // adding conference room to building b1 on floor 2
        System.out.println("--- ADD_CONFROOM c1 2 b1 ---");
        runMethodWithTryCatch(() -> {
            Building building = buildingServices.getBuilding("b1");
            Room room = roomServices.addRoom("c1", 2, building);
            System.out.println("created: " + room);
        });

        // adding multiple conference rooms
        System.out.println("--- ADD_CONFROOM ... ---");
        runMethodWithTryCatch(() -> {
            Building building = buildingServices.getBuilding("b1");
            System.out.println("created: " + roomServices.addRoom("c2", 1, building));
            System.out.println("created: " + roomServices.addRoom("c3", 1, building));
            System.out.println("created: " + roomServices.addRoom("c4", 1, building));
            System.out.println("created: " + roomServices.addRoom("c5", 1, building));
        });

        // Book conference room
        System.out.println("--- BOOK 1:5 b1 1 c1 ---");
        runMethodWithTryCatch(() -> {
            Building building = buildingServices.getBuilding("b1");
            roomServices.bookRoom(user.getUserId(), "c1", 1, building.getId(), 1, 5);
            Room room = roomServices.getRoom("c1", 1, "b1");
            System.out.println(room.getBookings());
        });

        // Book conference room
        System.out.println("--- BOOK 4:7 b1 1 c1 ---");
        runMethodWithTryCatch(() -> {
            Building building = buildingServices.getBuilding("b1");
            roomServices.bookRoom(user.getUserId(), "c1", 1, building.getId(), 4, 7);
            Room room = roomServices.getRoom("c1", 1, "b1");
            for (Booking booking : room.getBookings()) {
                System.out.println(booking);
            }
        });

        // checking available rooms
        System.out.println("--- SEARCH_CONFROOM 1:3 ---");
        runMethodWithTryCatch(() -> {
            for (Room room : roomServices.getAvailableRooms(1, 3)) {
                System.out.println(room);
            }
        });
    }
}
