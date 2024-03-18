package kz.sd.place.fragments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Parcelable
import android.widget.DatePicker
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.parcelize.Parcelize
import kz.sd.place.R
import kz.sd.place.base.BaseFragment
import kz.sd.place.databinding.FragmentBookTableBinding
import kz.sd.place.models.Place
import java.util.Calendar

class BookTableFragment:BaseFragment<FragmentBookTableBinding>(FragmentBookTableBinding::inflate) {
    private val args:BookTableFragmentArgs by navArgs()
    private lateinit var selectedDate:String
    private lateinit var selectedTime:String
    private var selectedNumberOfGuests:Int = 0
    override fun onBindView() {
        super.onBindView()
        binding.backBtn.setOnClickListener{
            findNavController().popBackStack()
        }
        binding.nextBtn.setOnClickListener {
            findNavController().navigate(BookTableFragmentDirections.actionBookTableFragmentToConfirmBookingFragment(ConfirmInfo(args.place, selectedTime, selectedDate, selectedNumberOfGuests)))
        }

        binding.dateBtn.setOnClickListener {
            showDatePickerDialog(requireContext()){year, month, dayOfMonth ->
                selectedDate = "$dayOfMonth/${month + 1}/$year"
                binding.selectedDate.text = selectedDate
            }
        }
        binding.timeBtn.setOnClickListener {
            showTimePickerDialog(requireContext()){hourOfDay, minute ->
                selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                binding.selectedTime.text = selectedTime
            }
        }
        binding.chipGroup.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedChipId = checkedIds.firstOrNull()

            selectedNumberOfGuests = when (selectedChipId) {
                R.id.chp1 -> 1
                R.id.chp2 -> 2
                R.id.chp3 -> 3
                R.id.chp4 -> 4
                R.id.chp5 -> 5
                R.id.chp6 -> 6
                else -> 0
            }
        }
    }
}
    fun showDatePickerDialog(context: Context, onDateSet: (year: Int, month: Int, dayOfMonth: Int) -> Unit) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            context,
            { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                onDateSet(selectedYear, selectedMonth, selectedDayOfMonth)
            },
            year,
            month,
            day
        )

        datePickerDialog.show()
    }

    fun showTimePickerDialog(context: Context, onTimeSet: (hourOfDay: Int, minute: Int) -> Unit) {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(
            context,
            { _, selectedHourOfDay, selectedMinute ->
                onTimeSet(selectedHourOfDay, selectedMinute)
            },
            hour,
            minute,
            true
        )

        timePickerDialog.show()
    }

@Parcelize
data class ConfirmInfo(
    val place: Place,
    val selectedTime:String,
    val selectedDate:String,
    val numberOfGuests:Int,
):Parcelable