package ak.quizo

object Constants {

    const val username:String="user_name"
    const val totalQuestion:String="total_question"
    const val correctAnswers:String="correct_answer"

    fun getQuestion():ArrayList<question> {
        val Questionlist = ArrayList<question>()

        val q1 = question(
            1,
            "who is this famous cricketer?",
            R.drawable.virat,
            "M.S.Dhoni",
            "Hardik Pandya",
            "Virat Kholi",
            "Rohit Sharma",
            3
        )
        Questionlist.add(q1)

        val q2 = question(
            2,
            "which car logo is this?",
            R.drawable.audi,
            "BMW",
            "AUDI",
            "MERCEDES",
            "FORD",
            2
        )
        Questionlist.add(q2)

        val q3 = question(
            3,
            "which Dog's breed is this?",
            R.drawable.husky,
            "Husky",
            "BEAGLE",
            "PITBULL",
            "GERMAN SHEPHERD",
            1
        )
        Questionlist.add(q3)

        val q4 = question(
            4,
            "In which year the below shown country got independence?",
            R.drawable.india,
            "1945",
            "1947",
            "1949",
            "1950",
            2
        )
        Questionlist.add(q4)

        val q5 = question(
            5,
            "who is this famous protagonist?",
            R.drawable.hitler,
            "Adolf Hitler",
            "Thomas Jefferson ",
            "Abraham Lincoln ",
            "Kaiser Wilhelm II ",
            1
        )
        Questionlist.add(q5)

        val q6 = question(
            6,
            "Name of game Shown in the Picture",
            R.drawable.valorant,
            "PUBG",
            "VALORANT",
            "CSGO",
            "GTA5",
            2
        )
        Questionlist.add(q6)

        val q7 = question(
            7,
            "Name of the Brand shown in the picture",
            R.drawable.starbucks,
            "Dutch Bros",
            "Lavazza",
            "Luckin Coffee",
            "Starbucks",
            4
        )
        Questionlist.add(q7)

        val q8 = question(
            8,
            "who is this Avenger?",
            R.drawable.thor,
            "HULK",
            "CAPTAIN AMERICA",
            "IRON-MAN",
            "THOR",
            4
        )
        Questionlist.add(q8)

        val q9 = question(
            9,
            "which company made this gadget",
            R.drawable.playstation,
            "APPLE",
            "BOSE",
            "SONY",
            "MICROMAX",
            3
        )
        Questionlist.add(q9)
        val q10 = question(
            10,
            "Which city is known as the 'Big Apple'?",
            R.drawable.big_apple,
            "Los Angeles",
            "Chicago",
            "New York City",
            "San Francisco",
            3
        )
        Questionlist.add(q10)

        val q11 = question(
            11,
            "Name of the famous landmark shown in the picture",
            R.drawable.taj_mahal,
            "Petra",
            "Taj Mahal",
            "Machu Picchu",
            "Great Wall of China",
            2
        )
        Questionlist.add(q11)

        val q12 = question(
            12,
            "Who is the author of the 'Harry Potter' book series?",
            R.drawable.harry_potter,
            "J.R.R. Tolkien",
            "J.K. Rowling",
            "George R.R. Martin",
            "Stephen King",
            2
        )
        Questionlist.add(q12)

        val q13 = question(
            13,
            "Name of the famous painting shown in the picture",
            R.drawable.mona_lisa,
            "The Starry Night",
            "The Last Supper",
            "The Persistence of Memory",
            "Mona Lisa",
            4
        )
        Questionlist.add(q13)

        val q14 = question(
            14,
            "Which planet is known as the 'Red Planet'?",
            R.drawable.mars,
            "Venus",
            "Mercury",
            "Mars",
            "Jupiter",
            3
        )
        Questionlist.add(q14)

        val q15 = question(
            15,
            "Name of the famous physicist known for the theory of relativity",
            R.drawable.einstein,
            "Isaac Newton",
            "Albert Einstein",
            "Galileo Galilei",
            "Nikola Tesla",
            2
        )
        Questionlist.add(q15)

        val q16 = question(
            16,
            "Which animal is the tallest living terrestrial animal?",
            R.drawable.giraffe,
            "Elephant",
            "Giraffe",
            "Kangaroo",
            "Zebra",
            2
        )
        Questionlist.add(q16)

        val q17 = question(
            17,
            "Name of the famous river shown in the picture",
            R.drawable.nile_river,
            "Amazon River",
            "Mississippi River",
            "Nile River",
            "Yangtze River",
            3
        )
        Questionlist.add(q17)

        val q18 = question(
            18,
            "What is the capital city of France?",
            R.drawable.eiffel_tower,
            "London",
            "Rome",
            "Paris",
            "Berlin",
            3
        )
        Questionlist.add(q18)

        val q19 = question(
            19,
            "Which country is known as the 'Land of the Rising Sun'?",
            R.drawable.japan,
            "China",
            "South Korea",
            "Japan",
            "Thailand",
            3
        )
        Questionlist.add(q19)

        val q20 = question(
            20,
            "Name of the famous scientist known for the theory of gravity",
            R.drawable.newton,
            "Isaac Newton",
            "Albert Einstein",
            "Marie Curie",
            "Charles Darwin",
            1
        )
        Questionlist.add(q20)

        return Questionlist
    }



    }
