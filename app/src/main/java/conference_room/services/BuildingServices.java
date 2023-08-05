package conference_room.services;

import conference_room.models.Building;
import conference_room.models.Room;
import conference_room.repository.BuildingRepository;

public class BuildingServices {
    BuildingRepository buildingRepository;
    RoomServices roomServices;

    public BuildingServices(BuildingRepository repo, RoomServices roomServices) {
        this.buildingRepository = repo;
        this.roomServices = roomServices;
    }

    public Building addBuilding(String buildingId) throws Exception {
        try {
            if (isBuildingPresent(buildingId)) {
                throw new Exception("Building with this id already exists");
            }
            return buildingRepository.save(new Building(buildingId));
        } catch (Exception e) {
            throw e;
        }
    }

    public void addFloor(String buildingId, int floorNumber) throws Exception {
        try {
            if (!isBuildingPresent(buildingId)) {
                throw new Exception("Building with this id does not exist");
            }
            buildingRepository.addFloor(floorNumber);
        } catch (Exception e) {
            throw e;
        }
    }

    public Room addConferenceRoom(String buildingId, int floorNumber, String roomId) throws Exception {
        try {
            if (!isBuildingPresent(buildingId)) {
                throw new Exception("Building with this id does not exist");
            }
            Building building = buildingRepository.getBuildingById(buildingId).get();
            if (!building.hasFloor(floorNumber)) {
                throw new Exception("Requested floor number does not exist");
            }
            Room room = roomServices.addRoom(roomId, floorNumber, building);
            buildingRepository.addRoom(buildingId, floorNumber, room);
            return room;
        } catch (Exception e) {
            throw e;
        }
    }

    private boolean isBuildingPresent(String buildingId) {
        return buildingRepository.getBuildingById(buildingId).isPresent();
    }
}
