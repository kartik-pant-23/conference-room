package conference_room.services;

import java.util.Optional;

import conference_room.models.Booking;
import conference_room.models.Building;
import conference_room.models.Room;
import conference_room.models.User;
import conference_room.repository.BookingRepository;
import conference_room.repository.RoomRepository;

public class RoomServices {
    RoomRepository roomRepository;
    BookingRepository bookingRepository;
    UserServices userServices;

    public RoomServices(RoomRepository roomRepository, BookingRepository bookingRepository, UserServices userServices) {
        this.roomRepository = roomRepository;
        this.bookingRepository = bookingRepository;
        this.userServices = userServices;
    }

    public Room addRoom(String roomId, int floorNumber, Building building) throws Exception {
        try {
            Optional<Room> room = roomRepository.getRoom(roomId, floorNumber, roomId);
            if (room.isPresent()) {
                throw new Exception("Requested room already exists");
            }
            return roomRepository.save(new Room(roomId, floorNumber, roomId));
        } catch (Exception e) {
            throw e;
        }
    }

    public void bookRoom(String userId, String roomId, int floorNumber, String buildingId, int startTime, int endTime)
            throws Exception {
        try {
            Room room = getRoom(roomId, floorNumber, buildingId);
            if (!room.isAvailable(startTime, endTime)) {
                throw new Exception("Room is already booked in this slot.");
            }
            User user = userServices.getUser(userId);
            Booking newBooking = new Booking(startTime, endTime, user, room);
            roomRepository.addBooking(roomId, newBooking);
        } catch (Exception e) {
            throw e;
        }
    }

    public void cancelBooking(Booking booking) throws Exception {
        try {
            booking.getRoom().getBookings().remove(booking);
            booking.getUser().getBookings().remove(booking);
            bookingRepository.delete(booking);
        } catch (Exception e) {
            throw e;
        }
    }

    public Room getRoom(String roomId, int floorNumber, String buildingId) throws Exception {
        Optional<Room> room = roomRepository.getRoom(roomId, floorNumber, buildingId);
        if (!room.isPresent()) {
            throw new Exception("Requested room does not exist");
        }
        return room.get();
    }

}
