package readingList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sun.misc.Contended;

/**
 * ReadingListController
 *
 * @author jongUn
 * @since 2018. 12. 03.
 */
@Controller
@RequestMapping("/")
public class ReadingListController {

	private static final String READER = "craig";
	private ReadingListRepository readingListRepository;

	@Autowired
	public ReadingListController(ReadingListRepository readingListRepository) {
		this.readingListRepository = readingListRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String readersBook(Model model) {
		List<Book> readingList = readingListRepository.findByReader(READER);

		if(readingList != null) {
			model.addAttribute("books", readingList);
		}

		return "readingList";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addToReadingList(Book book) {
		book.setReader(READER);
		readingListRepository.save(book);
		return "redirect:/";
	}
}
