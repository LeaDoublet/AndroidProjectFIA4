package com.example.tpandroid1

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import retrofit2.http.Query

public class FakeTmdbApi : Tmdbapi {
    val moshi: Moshi = Moshi.Builder().build()
    val jsonAdapter: JsonAdapter<TmdbMovieResult> = moshi.adapter(TmdbMovieResult::class.java)

    // Faux Json
    private val jsonresult = "{\n" +
            "  \"page\": 1,\n" +
            "  \"results\": [\n" +
            "    {\n" +
            "      \"backdrop_path\": \"/uVlUu174iiKhsUGqnOSy46eIIMU.jpg\",\n" +
            "      \"id\": 402431,\n" +
            "      \"title\": \"Wicked\",\n" +
            "      \"original_title\": \"Wicked\",\n" +
            "      \"overview\": \"Elphaba, a young woman misunderstood because of her green skin, and Glinda, a popular aristocrat gilded by privilege, become unlikely friends in the fantastical Land of Oz. As the two women struggle with their opposing personalities, their friendship is tested as both begin to fulfill their destinies as Glinda the Good and the Wicked Witch of the West.\",\n" +
            "      \"poster_path\": \"/c5Tqxeo1UpBvnAc3csUm7j3hlQl.jpg\",\n" +
            "      \"media_type\": \"movie\",\n" +
            "      \"adult\": false,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"genre_ids\": [18, 14, 10749],\n" +
            "      \"popularity\": 1485.249,\n" +
            "      \"release_date\": \"2024-11-20\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7.9,\n" +
            "      \"vote_count\": 161\n" +
            "    },\n" +
            "    {\n" +
            "      \"backdrop_path\": \"/iR79ciqhtaZ9BE7YFA1HpCHQgX4.jpg\",\n" +
            "      \"id\": 1100782,\n" +
            "      \"title\": \"Smile 2\",\n" +
            "      \"original_title\": \"Smile 2\",\n" +
            "      \"overview\": \"About to embark on a new world tour, global pop sensation Skye Riley begins experiencing increasingly terrifying and inexplicable events. Overwhelmed by the escalating horrors and the pressures of fame, Skye is forced to face her dark past to regain control of her life before it spirals out of control.\",\n" +
            "      \"poster_path\": \"/ht8Uv9QPv9y7K0RvUyJIaXOZTfd.jpg\",\n" +
            "      \"media_type\": \"movie\",\n" +
            "      \"adult\": false,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"genre_ids\": [27, 9648],\n" +
            "      \"popularity\": 2711.905,\n" +
            "      \"release_date\": \"2024-10-16\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 6.878,\n" +
            "      \"vote_count\": 617\n" +
            "    },\n" +
            "    {\n" +
            "      \"backdrop_path\": \"/euYIwmwkmz95mnXvufEmbL6ovhZ.jpg\",\n" +
            "      \"id\": 558449,\n" +
            "      \"title\": \"Gladiator II\",\n" +
            "      \"original_title\": \"Gladiator II\",\n" +
            "      \"overview\": \"Years after witnessing the death of the revered hero Maximus at the hands of his uncle, Lucius is forced to enter the Colosseum after his home is conquered by the tyrannical Emperors who now lead Rome with an iron fist. With rage in his heart and the future of the Empire at stake, Lucius must look to his past to find strength and honor to return the glory of Rome to its people.\",\n" +
            "      \"poster_path\": \"/2cxhvwyEwRlysAmRH4iodkvo0z5.jpg\",\n" +
            "      \"media_type\": \"movie\",\n" +
            "      \"adult\": false,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"genre_ids\": [28, 12, 36],\n" +
            "      \"popularity\": 2139.537,\n" +
            "      \"release_date\": \"2024-11-13\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 6.8,\n" +
            "      \"vote_count\": 666\n" +
            "    },\n" +
            "    {\n" +
            "      \"backdrop_path\": \"/n4ycOGj2tRLfINTJQ3wl0vNYqpR.jpg\",\n" +
            "      \"id\": 592983,\n" +
            "      \"title\": \"Spellbound\",\n" +
            "      \"original_title\": \"Spellbound\",\n" +
            "      \"overview\": \"When a powerful spell turns her parents into giant monsters, a teenage princess must journey into the wild to reverse the curse before it's too late.\",\n" +
            "      \"poster_path\": \"/xFSIygDiX70Esp9dheCgGX0Nj77.jpg\",\n" +
            "      \"media_type\": \"movie\",\n" +
            "      \"adult\": false,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"genre_ids\": [16, 14, 10751, 12, 35],\n" +
            "      \"popularity\": 331.827,\n" +
            "      \"release_date\": \"2024-11-22\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 6.9,\n" +
            "      \"vote_count\": 52\n" +
            "    },\n" +
            "    {\n" +
            "      \"backdrop_path\": \"/4eMqcuVITc6iY25rRApqRFGr5VP.jpg\",\n" +
            "      \"id\": 896151,\n" +
            "      \"title\": \"Blitz\",\n" +
            "      \"original_title\": \"Blitz\",\n" +
            "      \"overview\": \"In World War II London, nine-year-old George is evacuated to the countryside by his mother, Rita, to escape the bombings. Defiant and determined to return to his family, George embarks on an epic, perilous journey back home as Rita searches for him.\",\n" +
            "      \"poster_path\": \"/e9tyjbF2rugENtBolTtEhHOXgzD.jpg\",\n" +
            "      \"media_type\": \"movie\",\n" +
            "      \"adult\": false,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"genre_ids\": [10752, 18, 36],\n" +
            "      \"popularity\": 125.434,\n" +
            "      \"release_date\": \"2024-11-01\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 5.225,\n" +
            "      \"vote_count\": 51\n" +
            "    },\n" +
            "    {\n" +
            "      \"backdrop_path\": \"/v9acaWVVFdZT5yAU7J2QjwfhXyD.jpg\",\n" +
            "      \"id\": 1184918,\n" +
            "      \"title\": \"The Wild Robot\",\n" +
            "      \"original_title\": \"The Wild Robot\",\n" +
            "      \"overview\": \"After a shipwreck, an intelligent robot called Roz is stranded on an uninhabited island. To survive the harsh environment, Roz bonds with the island's animals and cares for an orphaned baby goose.\",\n" +
            "      \"poster_path\": \"/wTnV3PCVW5O92JMrFvvrRcV39RU.jpg\",\n" +
            "      \"media_type\": \"movie\",\n" +
            "      \"adult\": false,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"genre_ids\": [16, 878, 10751],\n" +
            "      \"popularity\": 2542.661,\n" +
            "      \"release_date\": \"2024-09-12\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 8.457,\n" +
            "      \"vote_count\": 3081\n" +
            "    },\n" +
            "    {\n" +
            "      \"backdrop_path\": \"/tElnmtQ6yz1PjN1kePNl8yMSb59.jpg\",\n" +
            "      \"id\": 1241982,\n" +
            "      \"title\": \"Moana 2\",\n" +
            "      \"original_title\": \"Moana 2\",\n" +
            "      \"overview\": \"After receiving an unexpected call from her wayfinding ancestors, Moana journeys alongside Maui and a new crew to the far seas of Oceania and into dangerous, long-lost waters for an adventure unlike anything she's ever faced.\",\n" +
            "      \"poster_path\": \"/m0SbwFNCa9epW1X60deLqTHiP7x.jpg\",\n" +
            "      \"media_type\": \"movie\",\n" +
            "      \"adult\": false,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"genre_ids\": [16, 12, 10751, 35],\n" +
            "      \"popularity\": 1268.378,\n" +
            "      \"release_date\": \"2024-11-27\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 8.4,\n" +
            "      \"vote_count\": 14\n" +
            "    },\n" +
            "    {\n" +
            "      \"backdrop_path\": \"/zpaodBqO2lcwJh2SQrFFf1Rn8Jy.jpg\",\n" +
            "      \"id\": 1100099,\n" +
            "      \"title\": \"We Live in Time\",\n" +
            "      \"original_title\": \"We Live in Time\",\n" +
            "      \"overview\": \"An up-and-coming chef and a recent divorcée find their lives forever changed when a chance encounter brings them together, in a decade-spanning, deeply moving romance.\",\n" +
            "      \"poster_path\": \"/oeDNBgnlGF6rnyX1P1K8Vl2f3lW.jpg\",\n" +
            "      \"media_type\": \"movie\",\n" +
            "      \"adult\": false,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"genre_ids\": [10749, 18, 35],\n" +
            "      \"popularity\": 438.946,\n" +
            "      \"release_date\": \"2024-10-10\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7.7,\n" +
            "      \"vote_count\": 72\n" +
            "    },\n" +
            "    {\n" +
            "      \"backdrop_path\": \"/dvBCdCohwWbsP5qAaglOXagDMtk.jpg\",\n" +
            "      \"id\": 533535,\n" +
            "      \"title\": \"Deadpool & Wolverine\",\n" +
            "      \"original_title\": \"Deadpool & Wolverine\",\n" +
            "      \"overview\": \"A listless Wade Wilson toils away in civilian life with his days as the morally flexible mercenary, Deadpool, behind him. But when his homeworld faces an existential threat, Wade must reluctantly suit-up again with an even more reluctant Wolverine.\",\n" +
            "      \"poster_path\": \"/8cdWjvZQUExUUTzyp4t6EDMubfO.jpg\",\n" +
            "      \"media_type\": \"movie\",\n" +
            "      \"adult\": false,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"genre_ids\": [28, 35, 878],\n" +
            "      \"popularity\": 1423.522,\n" +
            "      \"release_date\": \"2024-07-24\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7.69,\n" +
            "      \"vote_count\": 5579\n" +
            "    },\n" +
            "    {\n" +
            "      \"backdrop_path\": \"/thDLoKyWdgK6EWXwGsjYqAFenuN.jpg\",\n" +
            "      \"id\": 1182387,\n" +
            "      \"title\": \"Armor\",\n" +
            "      \"original_title\": \"Armor\",\n" +
            "      \"overview\": \"Armored truck security guard James Brody is working with his son Casey transporting millions of dollars between banks when a team of thieves led by Rook orchestrate a takeover of their truck to seize the riches. Following a violent car chase, Rook soon has the armored truck surrounded and James and Casey find themselves cornered onto a decrepit bridge.\",\n" +
            "      \"poster_path\": \"/pnXLFioDeftqjlCVlRmXvIdMsdP.jpg\",\n" +
            "      \"media_type\": \"movie\",\n" +
            "      \"adult\": false,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"genre_ids\": [28, 80, 53],\n" +
            "      \"popularity\": 96.849,\n" +
            "      \"release_date\": \"2024-10-30\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 4.9,\n" +
            "      \"vote_count\": 9\n" +
            "    },\n" +
            "    {\n" +
            "      \"backdrop_path\": \"/jhk6D8pim3yaByu1801kMoxXFaX.jpg\",\n" +
            "      \"id\": 98,\n" +
            "      \"title\": \"Gladiator\",\n" +
            "      \"original_title\": \"Gladiator\",\n" +
            "      \"overview\": \"In the year 180, the death of Emperor Marcus Aurelius throws the Roman Empire into chaos. Maximus is one of the Roman army's most capable and trusted generals, as well as a key advisor to the emperor. As Marcus' devious son Commodus ascends to the throne, Maximus is sentenced to execution. He escapes but is captured by slave traders. Renamed \\\"Spaniard\\\" and forced to become a gladiator, Maximus must battle to the death against other men for the amusement of paying audiences.\",\n" +
            "      \"poster_path\": \"/ty8TGRuvJLPUmAR1H1nRIsgwvim.jpg\",\n" +
            "      \"media_type\": \"movie\",\n" +
            "      \"adult\": false,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"genre_ids\": [28, 18, 12],\n" +
            "      \"popularity\": 627.523,\n" +
            "      \"release_date\": \"2000-05-04\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 8.217,\n" +
            "      \"vote_count\": 18694\n" +
            "    },\n" +
            "    {\n" +
            "      \"backdrop_path\": \"/9SSEUrSqhljBMzRe4aBTh17rUaC.jpg\",\n" +
            "      \"id\": 945961,\n" +
            "      \"title\": \"Alien: Romulus\",\n" +
            "      \"original_title\": \"Alien: Romulus\",\n" +
            "      \"overview\": \"While scavenging the deep ends of a derelict space station, a group of young space colonizers come face to face with the most terrifying life form in the universe.\",\n" +
            "      \"poster_path\": \"/b33nnKl1GSFbao4l3fZDDqsMx0F.jpg\",\n" +
            "      \"media_type\": \"movie\",\n" +
            "      \"adult\": false,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"genre_ids\": [27, 878],\n" +
            "      \"popularity\": 1265.317,\n" +
            "      \"release_date\": \"2024-08-13\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7.258,\n" +
            "      \"vote_count\": 2409\n" +
            "    },\n" +
            "    {\n" +
            "      \"backdrop_path\": \"/6lE2e6j8qbtQR8aHxQNJlwxdmKV.jpg\",\n" +
            "      \"id\": 974453,\n" +
            "      \"title\": \"Absolution\",\n" +
            "      \"original_title\": \"Absolution\",\n" +
            "      \"overview\": \"An aging ex-boxer gangster working as muscle for a Boston crime boss receives an upsetting diagnosis.  Despite a faltering memory, he attempts to rectify the sins of his past and reconnect with his estranged children. He is determined to leave a positive legacy for his grandson, but the criminal underworld isn’t done with him and won’t loosen their grip willingly.\",\n" +
            "      \"poster_path\": \"/cNtAslrDhk1i3IOZ16vF7df6lMy.jpg\",\n" +
            "      \"media_type\": \"movie\",\n" +
            "      \"adult\": false,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"genre_ids\": [28, 18, 80, 53],\n" +
            "      \"popularity\": 190.228,\n" +
            "      \"release_date\": \"2024-10-31\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 5.9,\n" +
            "      \"vote_count\": 52\n" +
            "    },\n" +
            "    {\n" +
            "      \"backdrop_path\": \"/ytorq8y3v9g1P4sXDFv2tbNg7Ms.jpg\",\n" +
            "      \"id\": 804406,\n" +
            "      \"title\": \"The Piano Lesson\",\n" +
            "      \"original_title\": \"The Piano Lesson\",\n" +
            "      \"overview\": \"A brother and sister's battle over a prized heirloom piano unleashes haunting truths about how the past is perceived — and who defines a family legacy.\",\n" +
            "      \"poster_path\": \"/cgampq63AqCrza6bnvmWqCcvCzY.jpg\",\n" +
            "      \"media_type\": \"movie\",\n" +
            "      \"adult\": false,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"genre_ids\": [18],\n" +
            "      \"popularity\": 51.45,\n" +
            "      \"release_date\": \"2024-11-07\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 5.9,\n" +
            "      \"vote_count\": 16\n" +
            "    },\n" +
            "    {\n" +
            "      \"backdrop_path\": \"/kLyhimpFheH1Z2w6nW1n6qWcGAC.jpg\",\n" +
            "      \"id\": 1097870,\n" +
            "      \"title\": \"Dear Santa\",\n" +
            "      \"original_title\": \"Dear Santa\",\n" +
            "      \"overview\": \"Likeable 6th grader Liam writes to Santa asking him to prove that he's real. But Liam is dyslexic and accidentally sends his letter to Satan instead, who shows up at Liam's house, excited to have his first fanboy letter and wanting a little of Liam's soul.\",\n" +
            "      \"poster_path\": \"/fRbDHbGBXg6kwQYr3CRYeKPJW5q.jpg\",\n" +
            "      \"media_type\": \"movie\",\n" +
            "      \"adult\": false,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"genre_ids\": [35, 14],\n" +
            "      \"popularity\": 43.531,\n" +
            "      \"release_date\": \"2024-11-24\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 9.3,\n" +
            "      \"vote_count\": 3\n" +
            "    },\n" +
            "    {\n" +
            "      \"backdrop_path\": \"/7h6TqPB3ESmjuVbxCxAeB1c9OB1.jpg\",\n" +
            "      \"id\": 933260,\n" +
            "      \"title\": \"The Substance\",\n" +
            "      \"original_title\": \"The Substance\",\n" +
            "      \"overview\": \"A fading celebrity decides to use a black market drug, a cell-replicating substance that temporarily creates a younger, better version of herself.\",\n" +
            "      \"poster_path\": \"/lqoMzCcZYEFK729d6qzt349fB4o.jpg\",\n" +
            "      \"media_type\": \"movie\",\n" +
            "      \"adult\": false,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"genre_ids\": [18, 27, 878],\n" +
            "      \"popularity\": 1348.076,\n" +
            "      \"release_date\": \"2024-09-07\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7.3,\n" +
            "      \"vote_count\": 2179\n" +
            "    },\n" +
            "    {\n" +
            "      \"backdrop_path\": \"/mI7fNHGhVhqxS6OrkHj6GZqIetu.jpg\",\n" +
            "      \"id\": 971606,\n" +
            "      \"title\": \"Out of My Mind\",\n" +
            "      \"original_title\": \"Out of My Mind\",\n" +
            "      \"overview\": \"Melody Brooks, a sixth grader with cerebral palsy, has a quick wit and a sharp mind, but because she is non-verbal and uses a wheelchair, she is not given the same opportunities as her classmates. When a young educator notices her student's untapped potential and Melody starts to participate in mainstream education, Melody shows that what she has to say is more important than how she says it.\",\n" +
            "      \"poster_path\": \"/o8qtMeCskitW5QwSu6O1nP4jN6z.jpg\",\n" +
            "      \"media_type\": \"movie\",\n" +
            "      \"adult\": false,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"genre_ids\": [18],\n" +
            "      \"popularity\": 47.531,\n" +
            "      \"release_date\": \"2024-01-19\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7.7,\n" +
            "      \"vote_count\": 17\n" +
            "    },\n" +
            "    {\n" +
            "      \"backdrop_path\": \"/liuBLPXvisMRo5w2JEKHXceWq5u.jpg\",\n" +
            "      \"id\": 1171640,\n" +
            "      \"title\": \"GTMAX\",\n" +
            "      \"original_title\": \"GTMAX\",\n" +
            "      \"overview\": \"When a notorious gang of bikers recruits her brother for a heist, a former motocross champion must face her deepest fears to keep her family safe.\",\n" +
            "      \"poster_path\": \"/bx92hl70NUhojjO3eV6LqKllj4L.jpg\",\n" +
            "      \"media_type\": \"movie\",\n" +
            "      \"adult\": false,\n" +
            "      \"original_language\": \"fr\",\n" +
            "      \"genre_ids\": [28, 80, 18],\n" +
            "      \"popularity\": 177.619,\n" +
            "      \"release_date\": \"2024-11-19\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 6.2,\n" +
            "      \"vote_count\": 28\n" +
            "    },\n" +
            "    {\n" +
            "      \"backdrop_path\": \"/3V4kLQg0kSqPLctI5ziYWabAZYF.jpg\",\n" +
            "      \"id\": 912649,\n" +
            "      \"title\": \"Venom: The Last Dance\",\n" +
            "      \"original_title\": \"Venom: The Last Dance\",\n" +
            "      \"overview\": \"Eddie and Venom are on the run. Hunted by both of their worlds and with the net closing in, the duo are forced into a devastating decision that will bring the curtains down on Venom and Eddie's last dance.\",\n" +
            "      \"poster_path\": \"/aosm8NMQ3UyoBVpSxyimorCQykC.jpg\",\n" +
            "      \"media_type\": \"movie\",\n" +
            "      \"adult\": false,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"genre_ids\": [878, 28, 12],\n" +
            "      \"popularity\": 3752.76,\n" +
            "      \"release_date\": \"2024-10-22\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 6.496,\n" +
            "      \"vote_count\": 841\n" +
            "    },\n" +
            "    {\n" +
            "      \"backdrop_path\": \"/cgH0j8T5NG5VBzok8erdP8mq0SI.jpg\",\n" +
            "      \"id\": 1290486,\n" +
            "      \"title\": \"The Merry Gentlemen\",\n" +
            "      \"original_title\": \"The Merry Gentlemen\",\n" +
            "      \"overview\": \"To save her parents' small-town nightclub, a Broadway dancer stages an all-male, Christmas-themed revue — and meets a guy with all the right moves.\",\n" +
            "      \"poster_path\": \"/4t80WORFWqDYf4BRwV2jrXNHJdN.jpg\",\n" +
            "      \"media_type\": \"movie\",\n" +
            "      \"adult\": false,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"genre_ids\": [10749, 35],\n" +
            "      \"popularity\": 278.083,\n" +
            "      \"release_date\": \"2024-11-20\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 5.9,\n" +
            "      \"vote_count\": 55\n" +
            "    }\n" +
            "  ],\n" +
            "  \"total_pages\": 500,\n" +
            "  \"total_results\": 10000\n" +
            "}".trimIndent()

    override
    suspend fun lastmovies(@Query("api_key") api_key: String): TmdbMovieResult {
        val res = jsonAdapter.fromJson(jsonresult)
        if (res != null) return res
        else return TmdbMovieResult()
    }

    override suspend fun getmoviedetail(movieId: Int, api_key: String): Movie {
        TODO("Not yet implemented")
    }

    override suspend fun getactor(api_key: String, person: String): TmdbActeurResult {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieByKeyWord(api_key: String, keyWord: String): TmdbMovieResult {
        TODO("Not yet implemented")
    }

    override suspend fun lastseries(api_key: String): TmdbSerieResult {
        TODO("Not yet implemented")
    }

    override suspend fun getseriedetail(serieId: Int, api_key: String): TmdbSerie {
        TODO("Not yet implemented")
    }

    override suspend fun getActeurs(api_key: String): TmdbActeurResult {
        TODO("Not yet implemented")
    }

    override suspend fun getSerieByKeyWord(api_key: String, keyWord: String): TmdbSerieResult {
        TODO("Not yet implemented")
    }

    override suspend fun getActeurByKeyWord(api_key: String, keyWord: String): TmdbActeurResult {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieDetailById(
        movieId: String,
        api_key: String,
        append: String
    ): TmdbMovieDetail {
        TODO("Not yet implemented")
    }

    override suspend fun getSerieDetailById(
        serieId: String,
        api_key: String,
        append: String
    ): TmdbSerieDetail {
        TODO("Not yet implemented")
    }
}