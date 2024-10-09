package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Comparator;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.appointment.Appointment;

/**
 * Sorts Appointment data in HealthContact.
 */
public class SortAppointmentCommand extends Command {
    public static final CommandWord COMMAND_WORD = new CommandWord("sortappointment", "soa");
    public static final String MESSAGE_USAGE =
            COMMAND_WORD + ": Sorts the list of appointments according to the specified field"
                    + "by alphabetical order.\n"
                    + "Parameters: c/CRITERIA (name, test, slot, doctor) o/ORDER (asc, desc)\n"
                    + "Example: " + COMMAND_WORD + " " + "c/name o/asc";

    public static final String MESSAGE_SORT_SUCCESS = "Sorted according to %1$s";

    private final String criteria;
    private final boolean isAscending;

    /**
     * @param criteria to be sorted by
     */
    public SortAppointmentCommand(String criteria, boolean isAscending) {
        requireAllNonNull(criteria);
        this.criteria = criteria;
        this.isAscending = isAscending;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        if (this.criteria.toLowerCase().equals("name")) {
            NameComparator nameComparator = new NameComparator();
            model.sortAppointments(nameComparator, this.isAscending);
        } else if (this.criteria.toLowerCase().equals("test")) {
            TestComparator testComparator = new TestComparator();
            model.sortAppointments(testComparator, this.isAscending);
        } else if (this.criteria.toLowerCase().equals("slot")) {
            SlotComparator slotComparator = new SlotComparator();
            model.sortAppointments(slotComparator, this.isAscending);
        } else if (this.criteria.toLowerCase().equals("doctor")) {
            DoctorComparator doctorComparator = new DoctorComparator();
            model.sortAppointments(doctorComparator, this.isAscending);
        } else {
            throw new CommandException(MESSAGE_USAGE);
        }

        String message = String.format(MESSAGE_SORT_SUCCESS, this.criteria);
        return new CommandResult(message);
    }

    /**
     * Compares two Appointments by name.
     */
    public class NameComparator implements Comparator<Appointment> {
        @Override
        public int compare(Appointment first, Appointment second) {
            if (first == null || second == null || first.getName() == null || second.getName() == null) {
                throw new NullPointerException("One of the appointments or their names is null");
            }
             String firstName = first.getName() != null ? first.getName().toString() : "";
             String secondName = second.getName() != null ? second.getName().toString() : "";
             return firstName.compareToIgnoreCase(secondName);
        }
    }

    /**
     * Compares two Appointments by medical test.
     */
    public class TestComparator implements Comparator<Appointment> {

        @Override
        public int compare(Appointment first, Appointment second) {
             String firstTest = first.getMedicalTest() != null ? first.getMedicalTest().toString() : "";
             String secondTest = second.getMedicalTest() != null ? second.getMedicalTest().toString() : "";
             return firstTest.compareToIgnoreCase(secondTest);
        }
    }

    /**
     * Compares two Appointments by slots.
            if (first == null || second == null || first.getSlot() == null || second.getSlot() == null) {
                throw new NullPointerException("One of the appointments or their slots is null");
            }
     */
    public class SlotComparator implements Comparator<Appointment> {
        @Override
        public int compare(Appointment first, Appointment second) {
             String firstSlot = first.getSlot() != null ? first.getSlot().toString() : "";
             String secondSlot = second.getSlot() != null ? second.getSlot().toString() : "";
             return firstSlot.compareToIgnoreCase(secondSlot);
        }
    }


    /**
     * Compares two Appointments by doctor.
     */
    public class DoctorComparator implements Comparator<Appointment> {
        @Override
        public int compare(Appointment first, Appointment second) {
             String firstDoctor = first.getDoctor() != null ? first.getDoctor().toString() : "";
             String secondDoctor = second.getDoctor() != null ? second.getDoctor().toString() : "";
             return firstDoctor.compareToIgnoreCase(secondDoctor);
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof SortAppointmentCommand)) {
            return false;
        }

        SortAppointmentCommand e = (SortAppointmentCommand) other;
        return criteria.equals(e.criteria)
                && isAscending == e.isAscending;
    }
}
