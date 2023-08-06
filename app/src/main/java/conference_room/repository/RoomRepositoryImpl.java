package conference_room.repository;

import java.util.*;
import java.util.stream.Collectors;

import conference_room.models.Booking;
import conference_room.models.Room;

public class RoomRepositoryImpl implements RoomRepository {
    private static Map<String, Room> rooms;

    public RoomRepositoryImpl() {
        if (rooms == null) {
            rooms = new HashMap<>();
        }
    }

    @Override
    public void addBooking(String roomId, int floorNumber, String buildingId, Booking booking) {
        String generatedRoomId = generateRoomId(roomId, floorNumber, buildingId);
        rooms.get(generatedRoomId).getBookings().add(booking);
    }

    @Override
    public List<Room> getAvailableRooms(int startTime, int endTime) {
        List<Room> allRooms = rooms.values().stream().collect(Collectors.toList());
        return allRooms.stream()
                .filter((room) -> room.isAvailable(startTime, endTime))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Room> getRoom(String roomId, int floorNumber, String buildingId) {
        String generatedRoomId = generateRoomId(roomId, floorNumber, buildingId);
        return Optional.ofNullable(rooms.get(generatedRoomId));
    }

    @Override
    public void removeBooking(String roomId, int floorNumber, String buildingId, Booking booking) {
        String generatedRoomId = generateRoomId(roomId, floorNumber, buildingId);
        rooms.get(generatedRoomId).getBookings().remove(booking);
    }

    @Override
    public Room save(Room room) {
        String generatedRoomId = generateRoomId(room.getRoomId(), room.getFloorNumber(), room.getBuildingId());
        rooms.putIfAbsent(generatedRoomId, room);
        return room;
    }

    private String generateRoomId(String roomId, int floorNumber, String buildingId) {
        return new StringBuilder()
                .append("room=[").append(roomId).append("] ")
                .append("floor=[").append(floorNumber).append("] ")
                .append("building=[").append(buildingId).append("]")
                .toString();

    }

}
