package kd.microlearn.main
import android.app.Application
import androidx.room.Room
import kd.microlearn.models.AppDatabase
import kd.microlearn.models.AreaModel
import kd.microlearn.models.PortionModel
import kd.microlearn.models.ThemeModel
import timber.log.Timber
import timber.log.Timber.i


class MainApp : Application() {

    val db = Room.databaseBuilder (
        applicationContext,
        AppDatabase::class.java,
        "microlearn.db"
    ).build()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        i("Placemark started")

        val areaDao = db.areaDao()
        areaDao.create(AreaModel(0, "Geography"))
        areaDao.create(AreaModel(1, "Culture"))
        areaDao.create(AreaModel(2, "Science"))

        val themeDao = db.themeDao()
        themeDao.create(ThemeModel(0, "Marine biology", "", 2))
        themeDao.create(ThemeModel(1, "Mountains", "",0))
        themeDao.create(ThemeModel(2, "Rivers", "",0))
        themeDao.create(ThemeModel(3, "Dances", "",1))
        themeDao.create(ThemeModel(4, "International cuisine", "",1))
        themeDao.create(ThemeModel(5, "Musical instruments", "",1))
        themeDao.create(ThemeModel(6, "Public transport", "",0))

        val portionDao = db.portionDao()
        portionDao.create(PortionModel(1,"Carpathian Mountains",
            "The Carpathian Mountains or Carpathians are a range of mountains forming an arc across Central Europe. Roughly 1,500 km long, it is the third-longest European mountain range after the Urals at 2,500 km and the Scandinavian Mountains at 1,700 km. The range stretches from the far eastern Czech Republic (3%) and Austria (1%) in the northwest through Slovakia (21%), Poland (10%), Ukraine (10%), Romania (50%) to Serbia (5%) in the south. The highest range within the Carpathians is known as the Tatra mountains in Slovakia and Poland, where the highest peaks exceed 2,600 m. The second-highest range is the Southern Carpathians in Romania, where the highest peaks range between 2,500 m and 2,550 m.",
            1))
        portionDao.create(PortionModel(2,"Danube",
            "The Danube is the second-longest river in Europe. It flows through much of Central and Southeastern Europe, from the Black Forest into the Black Sea. A large and historically important river, it was once a frontier of the Roman Empire and today connects ten European countries, running through their territories or being a border. Originating in Germany, the Danube flows southeast for 2,850 km, passing through or bordering Austria, Slovakia, Hungary, Croatia, Serbia, Romania, Bulgaria, Moldova, and Ukraine. Among the many cities on the river are 4 capitals: Vienna, Budapest, Belgrade and Bratislava. Its drainage basin amounts to 817 000 km² and extends into nine more countries.",
            2))
        portionDao.create(PortionModel(3,"Hopak",
            "Hopak is a Ukrainian folk dance originating as a male dance among the Zaporozhian Cossacks, but later danced by couples, male soloists, and mixed groups of dancers. It is performed most often as a solitary concert dance by amateur and professional Ukrainian dance ensembles, as well as other performers of folk dances. It has also been incorporated into larger artistic opuses such as operas, ballets and theatre.\nThe hopak is often popularly referred to as the \"National Dance of Ukraine\" and has become very popular in Poland. There are similar folkloric dance tunes known as Sirmpa in Leros, Greece.",
            3))
        portionDao.create(PortionModel(4,"Palyanytsya",
            "Palyanytsya is a type of Ukrainian hearth-baked bread, made mostly of wheat flour in a home oven. The yeast hearth bread has a semi-circular cut across the top third of the loaf.\nIn Christianity, palyanytsya, like bread in general, symbolizes happiness and can represent well-being, the body of God, affection, hospitality and security. Palyanytsya can also be interpreted as a symbol of the sun.\nAccording to popular belief, you should not eat a piece of palyanytsya after another person, as doing so will take away their happiness. It is also unlucky to leave a piece uneaten; and eating bread behind another person's back will \"eat\" their strength.",
            4))
        portionDao.create(PortionModel(5,"Trembita",
            "The trembita is an alpine horn made of wood. It is common among Ukrainian highlanders Hutsuls who live in western Ukraine, eastern Poland, Slovakia, and northern Romania.\nA trembita was used primarily by mountain dwellers known as Hutsuls and Gorals in the Carpathians, it was used as a signaling device to announce deaths, funerals, weddings.\nThe tube is made from a long straight piece of pine or spruce (preferably one that has been struck by lightning) which is split in two in order to carve out the core. The halves are once again joined together and then wrapped in birch bark or osier rings. It is also used by shepherds for signaling and communication in the forested mountains and for guiding sheep and dogs. The trembita has a timbre that is much brighter than that of the alpenhorn due to its narrow bore and very minor flare.",
            5))
        portionDao.create(PortionModel(6,"Kobza",
            "The kobza, also called bandurka, is a Ukrainian folk music instrument of the lute family, a relative of the Central European mandora. The term kobza however, has also been applied to a number of other Eastern European instruments distinct from the Ukrainian kobza.\nThe term kobza is of Turkic origin and is related to the terms kobyz and komuz, thought to have been introduced into the Ukrainian language in the 13th century with the migration of a sizable group of Turkic people from Abkhazia settling in the Poltava region. It was usually played by a bard or minstrel known as a kobzar (occasionally in earlier times a kobeznik), who accompanies his recitation of epic poetry called duma in Ukrainian.",
            5))
        portionDao.create(PortionModel(7,"Arsenalna (Kyiv Metro)",
            "Arsenalna is a station on Kyiv Metro’s Sviatoshynsko-Brovarska Line. The station was opened along with the first stage and is currently the deepest station in the world at 105.5 metres. This is attributed to Kyiv’s geography, where the high bank of the Dnipro River rises above the rest of the city. Also unusual is the station’s design, which lacks a central concourse and is thus similar in layout to stations on the London Underground.\nSince 1986, the station has the status of \"architectural monument of local significance\".",
            6))

    }
}