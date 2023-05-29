package kd.microlearn.main
import android.app.Application
import androidx.room.Room
import kd.microlearn.models.AppDatabase
import kd.microlearn.models.entities.*
import timber.log.Timber
import timber.log.Timber.i


class MainApp : Application() {

    lateinit var db : AppDatabase

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        i("Placemark started")

        db = Room.databaseBuilder (
            applicationContext,
            AppDatabase::class.java,
            "micro..learn.db"
        ).allowMainThreadQueries().build()

        val areaDao = db.areaDao()
        areaDao.upsert(AreaModel(1, "Geography"))
        areaDao.upsert(AreaModel(2, "Culture"))
        areaDao.upsert(AreaModel(3, "Science"))

        val themeDao = db.themeDao()
        themeDao.upsert(ThemeModel(1, "Marine biology", "", 3))
        themeDao.upsert(ThemeModel(2, "Mountains", "",1))
        themeDao.upsert(ThemeModel(3, "Rivers", "",1))
        themeDao.upsert(ThemeModel(4, "Dances", "",2))
        themeDao.upsert(ThemeModel(5, "International cuisine", "",2))
        themeDao.upsert(ThemeModel(6, "Musical instruments", "",2))
        themeDao.upsert(ThemeModel(7, "Public transport", "",1))

        val portionDao = db.portionDao()
        portionDao.upsert(
            PortionModel(1,"Carpathian Mountains",
            "The Carpathian Mountains or Carpathians are a range of mountains forming an arc across Central Europe. Roughly 1,500 km long, it is the third-longest European mountain range after the Urals at 2,500 km and the Scandinavian Mountains at 1,700 km. The range stretches from the far eastern Czech Republic (3%) and Austria (1%) in the northwest through Slovakia (21%), Poland (10%), Ukraine (10%), Romania (50%) to Serbia (5%) in the south. The highest range within the Carpathians is known as the Tatra mountains in Slovakia and Poland, where the highest peaks exceed 2,600 m. The second-highest range is the Southern Carpathians in Romania, where the highest peaks range between 2,500 m and 2,550 m.",
            2, 1)
        )
        portionDao.upsert(
            PortionModel(2,"Danube",
            "The Danube is the second-longest river in Europe. It flows through much of Central and Southeastern Europe, from the Black Forest into the Black Sea. A large and historically important river, it was once a frontier of the Roman Empire and today connects ten European countries, running through their territories or being a border. Originating in Germany, the Danube flows southeast for 2,850 km, passing through or bordering Austria, Slovakia, Hungary, Croatia, Serbia, Romania, Bulgaria, Moldova, and Ukraine. Among the many cities on the river are 4 capitals: Vienna, Budapest, Belgrade and Bratislava. Its drainage basin amounts to 817 000 km² and extends into nine more countries.",
            3, 1)
        )
        portionDao.upsert(
            PortionModel(3,"Hopak",
            "Hopak is a Ukrainian folk dance originating as a male dance among the Zaporozhian Cossacks, but later danced by couples, male soloists, and mixed groups of dancers. It is performed most often as a solitary concert dance by amateur and professional Ukrainian dance ensembles, as well as other performers of folk dances. It has also been incorporated into larger artistic opuses such as operas, ballets and theatre.\nThe hopak is often popularly referred to as the \"National Dance of Ukraine\" and has become very popular in Poland. There are similar folkloric dance tunes known as Sirmpa in Leros, Greece.",
            4, 1)
        )
        portionDao.upsert(
            PortionModel(4,"Palyanytsya",
            "Palyanytsya is a type of Ukrainian hearth-baked bread, made mostly of wheat flour in a home oven. The yeast hearth bread has a semi-circular cut across the top third of the loaf.\nIn Christianity, palyanytsya, like bread in general, symbolizes happiness and can represent well-being, the body of God, affection, hospitality and security. Palyanytsya can also be interpreted as a symbol of the sun.\nAccording to popular belief, you should not eat a piece of palyanytsya after another person, as doing so will take away their happiness. It is also unlucky to leave a piece uneaten; and eating bread behind another person's back will \"eat\" their strength.",
            5, 1)
        )
        portionDao.upsert(
            PortionModel(5,"Trembita",
            "The trembita is an alpine horn made of wood. It is common among Ukrainian highlanders Hutsuls who live in western Ukraine, eastern Poland, Slovakia, and northern Romania.\nA trembita was used primarily by mountain dwellers known as Hutsuls and Gorals in the Carpathians, it was used as a signaling device to announce deaths, funerals, weddings.\nThe tube is made from a long straight piece of pine or spruce (preferably one that has been struck by lightning) which is split in two in order to carve out the core. The halves are once again joined together and then wrapped in birch bark or osier rings. It is also used by shepherds for signaling and communication in the forested mountains and for guiding sheep and dogs. The trembita has a timbre that is much brighter than that of the alpenhorn due to its narrow bore and very minor flare.",
            6, 1)
        )
        portionDao.upsert(
            PortionModel(6,"Kobza",
            "The kobza, also called bandurka, is a Ukrainian folk music instrument of the lute family, a relative of the Central European mandora. The term kobza however, has also been applied to a number of other Eastern European instruments distinct from the Ukrainian kobza.\nThe term kobza is of Turkic origin and is related to the terms kobyz and komuz, thought to have been introduced into the Ukrainian language in the 13th century with the migration of a sizable group of Turkic people from Abkhazia settling in the Poltava region. It was usually played by a bard or minstrel known as a kobzar (occasionally in earlier times a kobeznik), who accompanies his recitation of epic poetry called duma in Ukrainian.",
            6, 2)
        )
        portionDao.upsert(
            PortionModel(7,"Arsenalna (Kyiv Metro)",
            "Arsenalna is a station on Kyiv Metro’s Sviatoshynsko-Brovarska Line. The station was opened along with the first stage and is currently the deepest station in the world at 105.5 metres. This is attributed to Kyiv’s geography, where the high bank of the Dnipro River rises above the rest of the city. Also unusual is the station’s design, which lacks a central concourse and is thus similar in layout to stations on the London Underground.\nSince 1986, the station has the status of \"architectural monument of local significance\".",
            7, 1)
        )
        portionDao.upsert(
            PortionModel(8,"Alps",
                "The Alps are the highest and most extensive mountain range that is entirely in Europe,[b][2] stretching approximately 1,200 km (750 mi) across seven Alpine countries (from west to east): France, Switzerland, Italy, Liechtenstein, Austria, Germany, and Slovenia.[c][4]\n\nThe Alpine arch extends from Nice on the western Mediterranean to Trieste on the Adriatic and Vienna at the beginning of the Pannonian Basin. The mountains were formed over tens of millions of years as the African and Eurasian tectonic plates collided. Extreme shortening caused by the event resulted in marine sedimentary rocks rising by thrusting and folding into high mountain peaks such as Mont Blanc and the Matterhorn.\n\nMont Blanc spans the French–Italian border, and at 4,809 m (15,778 ft) is the highest mountain in the Alps. The Alpine region area contains 128 peaks higher than 4,000 m (13,000 ft).\n",
                2, 2)
        )
        portionDao.upsert(
            PortionModel(9,"Himalayas",
                "The Himalayas or Himalaya frost is a mountain range in Asia, separating the plains of the Indian subcontinent from the Tibetan Plateau. The range has some of the Earth's highest peaks, including the very highest, Mount Everest. Over 100 peaks exceeding 7,200 m (23,600 ft) in elevation lie in the Himalayas.\n\nThe Himalayas abut or cross five countries: Bhutan, India, Nepal, China, and Pakistan. The sovereignty of the range in the Kashmir region is disputed among India, Pakistan, and China.[4] The Himalayan range is bordered on the northwest by the Karakoram and Hindu Kush ranges, on the north by the Tibetan Plateau, and on the south by the Indo-Gangetic Plain. Some of the world's major rivers, the Indus, the Ganges, and the Tsangpo–Brahmaputra, rise in the vicinity of the Himalayas, and their combined drainage basin is home to some 600 million people; 53 million people live in the Himalayas.[5] The Himalayas have profoundly shaped the cultures of South Asia and Tibet. Many Himalayan peaks are sacred in Hinduism,Jainism and Buddhism. The summits of several—Kangchenjunga (from the Indian side), Gangkhar Puensum, Machapuchare, Nanda Devi, and Kailas in the Tibetan Transhimalaya—are off-limits to climbers.\n",
                2, 3)
        )
        portionDao.upsert(
            PortionModel(10,"Andes",
                "The Andes are the longest continental mountain range in the world, forming a continuous highland along the western edge of South America. The range is 8,900 km (5,530 mi) long, 200 to 700 km (124 to 435 mi) wide (widest between 18°S – 20°S latitude), and has an average height of about 4,000 m (13,123 ft). The Andes extend from north to south through seven South American countries: Venezuela, Colombia, Ecuador, Peru, Bolivia, Chile and Argentina.\n\nAlong their length, the Andes are split into several ranges, separated by intermediate depressions. The Andes are the location of several high plateaus—some of which host major cities such as Quito, Bogotá, Cali, Arequipa, Medellín, Bucaramanga, Sucre, Mérida, El Alto and La Paz. The Altiplano plateau is the world's second-highest after the Tibetan Plateau. These ranges are in turn grouped into three major divisions based on climate: the Tropical Andes, the Dry Andes, and the Wet Andes.\n\nThe Andes are also part of the American Cordillera, a chain of mountain ranges (cordillera) that consists of an almost continuous sequence of mountain ranges that form the western \"backbone\" of the Americas and Antarctica.",
                2, 4)
        )

        val userDao = db.userDao()
        userDao.upsert(UserModel(1, "Kateryna", "Miasnikova", "kateryna@miasnikova.kd", "yxcvbnm"))
        userDao.upsert(UserModel(2, "Daria", "Melnyk", "daria@melnyk.kd", "asdfghj"))
        userDao.upsert(UserModel(3, "Luisa", "Mirona", "luisa@mirona.kd", "poiuztr"))

        val factDao = db.factDao()
        factDao.upsert(FactModel(1, "There is a man who claims to have traveled to an alternate dimension in which The Beatles never broke up and brought back a mix tape of The Beatles songs, no one in this dimension has ever heard.", "http://instanerd.me/v/73/the-beatles"))
        factDao.upsert(FactModel(2, "Eating dark chocolate widens arteries and promotes healthy blood flow that can prevent the buildup of plaque that can block arteries.", "http://instanerd.me/v/328/benefits-of-dark-chocolate"))
        factDao.upsert(FactModel(3, "Pamukkale is mysterious place in Turkey also known as Cotton Castle. There are seventeen hot-water springs in the area that spill out water in temperatures ranging from 95 degrees to 212 degrees, which contains a high concentration of calcium bicarbonate. The water flows off a cliff, cools and hardens into calcium deposits that form terraces. These terraces are as white as cotton and bright enough to be easily seen from the town of Denizli.", "http://instanerd.me/v/208/pamukkale-is-mysterious-place-in-turkey"))
        factDao.upsert(FactModel(4, "In order female pigeon's ovaries to function, she must look into another pigeon or at least her own reflection in the mirror.", "http://instanerd.me/v/235/the-female-pigeon-cannot-lay-eggs-if-she-is-alone"))
        factDao.upsert(FactModel(5, "In severe situations of dehydration when the electrolytes are thrown out of balance and can create serious problems, a drink of a pure and clean coconut water can increase the levels of electrolyte potassium and restore the hydration.", "http://instanerd.me/v/221/the-truth-about-coconut-water"))

        val feedbackDao = db.feedbackDao()
        feedbackDao.upsert(FeedbackModel(1, 1, "Sentences are not logically connected enough", 1))
        feedbackDao.upsert(FeedbackModel(2, 4, "Good quality of material", 1))
        feedbackDao.upsert(FeedbackModel(3, 3, "Sentences are not logically connected enough", 2))
        feedbackDao.upsert(FeedbackModel(4, 5, "Good quality of material", 3))
        feedbackDao.upsert(FeedbackModel(5, 5, "Good quality of material", 4))
        feedbackDao.upsert(FeedbackModel(6, 2, "Too short portion", 4))


        val likedFactDao = db.likedFactDao()
        likedFactDao.upsert(LikedFactModel(1,1))
        likedFactDao.upsert(LikedFactModel(2,1))
        likedFactDao.upsert(LikedFactModel(1,2))
        likedFactDao.upsert(LikedFactModel(1,3))
        likedFactDao.upsert(LikedFactModel(2,5))

        val learnsThemeDao = db.learnsThemeDao()
        learnsThemeDao.upsert(LearnsThemeModel(1,1))
        learnsThemeDao.upsert(LearnsThemeModel(1,2))
        learnsThemeDao.upsert(LearnsThemeModel(1,3))
        learnsThemeDao.upsert(LearnsThemeModel(1,4))
        learnsThemeDao.upsert(LearnsThemeModel(1,5))
        learnsThemeDao.upsert(LearnsThemeModel(1,6))
        learnsThemeDao.upsert(LearnsThemeModel(2,1))
        learnsThemeDao.upsert(LearnsThemeModel(2,3))
        learnsThemeDao.upsert(LearnsThemeModel(2,5))
        learnsThemeDao.upsert(LearnsThemeModel(2,7))
        learnsThemeDao.upsert(LearnsThemeModel(3,6))

        val studiedPortionDao = db.studiedPortionDao()
        studiedPortionDao.upsert(StudiedPortionModel(1,1))
    }
}