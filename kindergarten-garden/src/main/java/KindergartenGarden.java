import java.util.LinkedList;
import java.util.List;

class KindergartenGarden {
    private String[] garden;

    KindergartenGarden(String garden) {
        this.garden = garden.split("\n");
    }

    List<Plant> getPlantsOfStudent(String student) {
        List<Plant> plantsOfStudent = new LinkedList<>();
        int studentStartIndex = (student.charAt(0) - 'A') * 2;

        for (int i = 0; i < garden.length; i++) {
            plantsOfStudent.add(Plant.getPlant(garden[i].charAt(studentStartIndex)));
            plantsOfStudent.add(Plant.getPlant(garden[i].charAt(studentStartIndex + 1)));
        }

        return plantsOfStudent;
    }

}
