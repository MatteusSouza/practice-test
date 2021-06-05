package com.istody.simulei.data

data class Folder(
    var folder: String,
    val exams: List<Exam>
)

data class Exam(
    val exam: String,
    val questions : List<Question>
)

data class Question(
    val question: String,
    val answerList: List<Answer>
)

data class Answer(
    val answer : String = ""
)


fun getExampleData() : List<Folder> {
    return folderListExample
}

fun getExampleFolderList() : List<String> {
    val folderList = mutableListOf<String>()

    for(n in getExampleData()){
        folderList.add(n.folder)
    }
    return folderList.toList()
}

fun getExampleExamList(folderId : Int) : List<Exam> {

    return getExampleData()[folderId].exams

}

fun getExampleQuestionList(folderId: Int, examId: Int) : List<Question> {
    val examList = getExampleExamList(folderId)

    return examList[examId].questions

}



// ========================
private val questionListExample = listOf<Question>(

    Question(
        question = "This modern version of the fairy tale Little Red Riding Hood addresses different social issues.\n" +
                "One of these issues is:",
        answerList = listOf(
            Answer("religious tolerance"),
            Answer("animal protection"),
            Answer("linguistic prejudice"),
            Answer("racial discrimination"),
        )
    ),
    Question(
        question = "Little Red Riding Hood’s mother mentions a special compassionate mission exemption form (l. 7).\n" +
                "This form includes a permission to perform the following action:",
        answerList = listOf(
            Answer("pick the flowers"),
            Answer("cross the forest"),
            Answer("carry the basket"),
            Answer("carry the basket"),
        )
    ),
    Question(
        question = "– But mother, aren’t you oppressing me by ordering me to do this? (l. 8)\n" +
                "In the sentence above, the word but fulfills the function of:",
        answerList = listOf(
            Answer("calling attention"),
            Answer("signalling exception"),
            Answer("suggesting expectation"),
            Answer("introducing objection"),
        )
    ),
    Question(
        question = "A fairy tale consists of both narrative and descriptive sequences.\n" +
                "The lines of the story that present predominantly descriptive sequences are:",
        answerList = listOf(
            Answer("11 to 15"),
            Answer("16 to 20"),
            Answer("21 to 26"),
            Answer("27 to 32"),
        )
    ),
    Question(
        question = "The classic fairy tale finishes by the woodchopper killing another character. However, this does \n" +
                "not happen in this modern version.\n" +
                "In the end of this version, the woodchopper carries out the act of:",
        answerList = listOf(
            Answer("saving the wolf"),
            Answer("arresting the girl"),
            Answer("calling the police"),
            Answer("hiding the grandmother"),
        )
    ),
    Question(
        question = "Um comerciante, para aumentar as vendas de seu estabelecimento, fez a seguinte promoção \n" +
                "para determinado produto:\n" +
                "COMPRE 4 UNIDADES E LEVE 5\n" +
                "Essa promoção representa um desconto de x% na venda de 5 unidades.\n" +
                "O valor de x é igual a",
        answerList = listOf(
            Answer("10"),
            Answer("15"),
            Answer("20"),
            Answer("25"),
        )
    ),
    Question(
        question = "Um fisioterapeuta elaborou o seguinte plano de treinos diários para o condicionamento de um \n" +
                "maratonista que se recupera de uma contusão:\n" +
                "• primeiro dia - corrida de 6 km;\n" +
                "• dias subsequentes - acréscimo de 2 km à corrida de cada dia imediatamente anterior.\n" +
                "O último dia de treino será aquele em que o atleta correr 42 km.\n" +
                "O total percorrido pelo atleta nesse treinamento, do primeiro ao último dia, em quilômetros, \n" +
                "corresponde a:",
        answerList = listOf(
            Answer("114"),
            Answer("338"),
            Answer("456"),
            Answer("484"),
        )
    ),
    Question(
        question = "This modern version of the fairy tale Little Red Riding Hood addresses different social issues.\n" +
                "One of these issues is:",
        answerList = listOf(
            Answer("religious tolerance"),
            Answer("animal protection"),
            Answer("linguistic prejudice"),
            Answer("racial discrimination"),
        )
    ),
    Question(
        question = "Little Red Riding Hood’s mother mentions a special compassionate mission exemption form (l. 7).\n" +
                "This form includes a permission to perform the following action:",
        answerList = listOf(
            Answer("pick the flowers"),
            Answer("cross the forest"),
            Answer("carry the basket"),
            Answer("carry the basket"),
        )
    ),
    Question(
        question = "– But mother, aren’t you oppressing me by ordering me to do this? (l. 8)\n" +
                "In the sentence above, the word but fulfills the function of:",
        answerList = listOf(
            Answer("calling attention"),
            Answer("signalling exception"),
            Answer("suggesting expectation"),
            Answer("introducing objection"),
        )
    ),
    Question(
        question = "A fairy tale consists of both narrative and descriptive sequences.\n" +
                "The lines of the story that present predominantly descriptive sequences are:",
        answerList = listOf(
            Answer("11 to 15"),
            Answer("16 to 20"),
            Answer("21 to 26"),
            Answer("27 to 32"),
        )
    ),
    Question(
        question = "The classic fairy tale finishes by the woodchopper killing another character. However, this does \n" +
                "not happen in this modern version.\n" +
                "In the end of this version, the woodchopper carries out the act of:",
        answerList = listOf(
            Answer("saving the wolf"),
            Answer("arresting the girl"),
            Answer("calling the police"),
            Answer("hiding the grandmother"),
        )
    ),
    Question(
        question = "Um comerciante, para aumentar as vendas de seu estabelecimento, fez a seguinte promoção \n" +
                "para determinado produto:\n" +
                "COMPRE 4 UNIDADES E LEVE 5\n" +
                "Essa promoção representa um desconto de x% na venda de 5 unidades.\n" +
                "O valor de x é igual a",
        answerList = listOf(
            Answer("10"),
            Answer("15"),
            Answer("20"),
            Answer("25"),
        )
    ),
    Question(
        question = "Um fisioterapeuta elaborou o seguinte plano de treinos diários para o condicionamento de um \n" +
                "maratonista que se recupera de uma contusão:\n" +
                "• primeiro dia - corrida de 6 km;\n" +
                "• dias subsequentes - acréscimo de 2 km à corrida de cada dia imediatamente anterior.\n" +
                "O último dia de treino será aquele em que o atleta correr 42 km.\n" +
                "O total percorrido pelo atleta nesse treinamento, do primeiro ao último dia, em quilômetros, \n" +
                "corresponde a:",
        answerList = listOf(
            Answer("114"),
            Answer("338"),
            Answer("456"),
            Answer("484"),
        )
    ),
    Question(
        question = "This modern version of the fairy tale Little Red Riding Hood addresses different social issues.\n" +
                "One of these issues is:",
        answerList = listOf(
            Answer("religious tolerance"),
            Answer("animal protection"),
            Answer("linguistic prejudice"),
            Answer("racial discrimination"),
        )
    ),
    Question(
        question = "Little Red Riding Hood’s mother mentions a special compassionate mission exemption form (l. 7).\n" +
                "This form includes a permission to perform the following action:",
        answerList = listOf(
            Answer("pick the flowers"),
            Answer("cross the forest"),
            Answer("carry the basket"),
            Answer("carry the basket"),
        )
    ),
    Question(
        question = "– But mother, aren’t you oppressing me by ordering me to do this? (l. 8)\n" +
                "In the sentence above, the word but fulfills the function of:",
        answerList = listOf(
            Answer("calling attention"),
            Answer("signalling exception"),
            Answer("suggesting expectation"),
            Answer("introducing objection"),
        )
    ),
    Question(
        question = "A fairy tale consists of both narrative and descriptive sequences.\n" +
                "The lines of the story that present predominantly descriptive sequences are:",
        answerList = listOf(
            Answer("11 to 15"),
            Answer("16 to 20"),
            Answer("21 to 26"),
            Answer("27 to 32"),
        )
    ),
    Question(
        question = "The classic fairy tale finishes by the woodchopper killing another character. However, this does \n" +
                "not happen in this modern version.\n" +
                "In the end of this version, the woodchopper carries out the act of:",
        answerList = listOf(
            Answer("saving the wolf"),
            Answer("arresting the girl"),
            Answer("calling the police"),
            Answer("hiding the grandmother"),
        )
    ),
    Question(
        question = "Um comerciante, para aumentar as vendas de seu estabelecimento, fez a seguinte promoção \n" +
                "para determinado produto:\n" +
                "COMPRE 4 UNIDADES E LEVE 5\n" +
                "Essa promoção representa um desconto de x% na venda de 5 unidades.\n" +
                "O valor de x é igual a",
        answerList = listOf(
            Answer("10"),
            Answer("15"),
            Answer("20"),
            Answer("25"),
        )
    ),
    Question(
        question = "Um fisioterapeuta elaborou o seguinte plano de treinos diários para o condicionamento de um \n" +
                "maratonista que se recupera de uma contusão:\n" +
                "• primeiro dia - corrida de 6 km;\n" +
                "• dias subsequentes - acréscimo de 2 km à corrida de cada dia imediatamente anterior.\n" +
                "O último dia de treino será aquele em que o atleta correr 42 km.\n" +
                "O total percorrido pelo atleta nesse treinamento, do primeiro ao último dia, em quilômetros, \n" +
                "corresponde a:",
        answerList = listOf(
            Answer("114"),
            Answer("338"),
            Answer("456"),
            Answer("484"),
        )
    ),
    Question(
        question = "This modern version of the fairy tale Little Red Riding Hood addresses different social issues.\n" +
                "One of these issues is:",
        answerList = listOf(
            Answer("religious tolerance"),
            Answer("animal protection"),
            Answer("linguistic prejudice"),
            Answer("racial discrimination"),
        )
    ),
    Question(
        question = "Little Red Riding Hood’s mother mentions a special compassionate mission exemption form (l. 7).\n" +
                "This form includes a permission to perform the following action:",
        answerList = listOf(
            Answer("pick the flowers"),
            Answer("cross the forest"),
            Answer("carry the basket"),
            Answer("carry the basket"),
        )
    ),
    Question(
        question = "– But mother, aren’t you oppressing me by ordering me to do this? (l. 8)\n" +
                "In the sentence above, the word but fulfills the function of:",
        answerList = listOf(
            Answer("calling attention"),
            Answer("signalling exception"),
            Answer("suggesting expectation"),
            Answer("introducing objection"),
        )
    ),
    Question(
        question = "A fairy tale consists of both narrative and descriptive sequences.\n" +
                "The lines of the story that present predominantly descriptive sequences are:",
        answerList = listOf(
            Answer("11 to 15"),
            Answer("16 to 20"),
            Answer("21 to 26"),
            Answer("27 to 32"),
        )
    ),
    Question(
        question = "The classic fairy tale finishes by the woodchopper killing another character. However, this does \n" +
                "not happen in this modern version.\n" +
                "In the end of this version, the woodchopper carries out the act of:",
        answerList = listOf(
            Answer("saving the wolf"),
            Answer("arresting the girl"),
            Answer("calling the police"),
            Answer("hiding the grandmother"),
        )
    ),
    Question(
        question = "Um comerciante, para aumentar as vendas de seu estabelecimento, fez a seguinte promoção \n" +
                "para determinado produto:\n" +
                "COMPRE 4 UNIDADES E LEVE 5\n" +
                "Essa promoção representa um desconto de x% na venda de 5 unidades.\n" +
                "O valor de x é igual a",
        answerList = listOf(
            Answer("10"),
            Answer("15"),
            Answer("20"),
            Answer("25"),
        )
    ),
    Question(
        question = "Um fisioterapeuta elaborou o seguinte plano de treinos diários para o condicionamento de um \n" +
                "maratonista que se recupera de uma contusão:\n" +
                "• primeiro dia - corrida de 6 km;\n" +
                "• dias subsequentes - acréscimo de 2 km à corrida de cada dia imediatamente anterior.\n" +
                "O último dia de treino será aquele em que o atleta correr 42 km.\n" +
                "O total percorrido pelo atleta nesse treinamento, do primeiro ao último dia, em quilômetros, \n" +
                "corresponde a:",
        answerList = listOf(
            Answer("114"),
            Answer("338"),
            Answer("456"),
            Answer("484"),
        )
    )

)
// =========================
private val enemExamListExample = listOf<Exam>(

    Exam(exam = "Enem 2021 Simulado", questions = questionListExample),
    Exam(exam = "Enem 2020 - Dia1 ", questions = questionListExample),
    Exam(exam = "Enem 2020 - Dia2", questions = questionListExample),
    Exam(exam = "Enem 2019 - Dia1 ", questions = questionListExample),
    Exam(exam = "Enem 2019 - Dia2", questions = questionListExample),
    Exam(exam = "Enem 2018 - Dia1 ", questions = questionListExample),
    Exam(exam = "Enem 2018 - Dia2", questions = questionListExample),
    Exam(exam = "Enem 2017 - Dia1 ", questions = questionListExample),
    Exam(exam = "Enem 2017 - Dia2", questions = questionListExample),
    Exam(exam = "Enem 2016 - Dia1 ", questions = questionListExample),
    Exam(exam = "Enem 2016 - Dia2", questions = questionListExample),
    Exam(exam = "Enem 2015 - Dia1 ", questions = questionListExample),
    Exam(exam = "Enem 2015 - Dia2", questions = questionListExample),
    Exam(exam = "Enem 2014 - Dia1 ", questions = questionListExample),
    Exam(exam = "Enem 2014 - Dia2", questions = questionListExample),
    Exam(exam = "Enem 2013 - Dia1 ", questions = questionListExample),
    Exam(exam = "Enem 2013 - Dia2", questions = questionListExample),
    Exam(exam = "Enem 2012 - Dia1 ", questions = questionListExample),
    Exam(exam = "Enem 2012 - Dia2", questions = questionListExample),
    Exam(exam = "Enem 2011 - Dia1 ", questions = questionListExample),
    Exam(exam = "Enem 2011 - Dia2", questions = questionListExample),
    Exam(exam = "Enem 2010 - Dia1 ", questions = questionListExample),
    Exam(exam = "Enem 2010 - Dia2", questions = questionListExample),
    Exam(exam = "Enem 2009 - Dia1 ", questions = questionListExample),
    Exam(exam = "Enem 2009 - Dia2", questions = questionListExample),
    Exam(exam = "Enem 2008 - Dia1 ", questions = questionListExample),
    Exam(exam = "Enem 2008 - Dia2", questions = questionListExample)

)
private val uerjExamListExample = listOf<Exam>(

    Exam(exam = "UERJ 2021 Simulado", questions = questionListExample),
    Exam(exam = "UERJ 2020 1ª Fase", questions = questionListExample),
    Exam(exam = "UERJ 2019 1ª Fase", questions = questionListExample),
    Exam(exam = "UERJ 2018 1ª Fase", questions = questionListExample),
    Exam(exam = "UERJ 2017 1ª Fase", questions = questionListExample),
    Exam(exam = "UERJ 2016 1ª Fase", questions = questionListExample),
    Exam(exam = "UERJ 2015 1ª Fase", questions = questionListExample),
    Exam(exam = "UERJ 2014 1ª Fase", questions = questionListExample),
    Exam(exam = "UERJ 2013 1ª Fase", questions = questionListExample),
    Exam(exam = "UERJ 2012 1ª Fase", questions = questionListExample),
    Exam(exam = "UERJ 2011 1ª Fase", questions = questionListExample),
    Exam(exam = "UERJ 2010 1ª Fase", questions = questionListExample),
    Exam(exam = "UERJ 2009 1ª Fase", questions = questionListExample),
    Exam(exam = "UERJ 2008 1ª Fase", questions = questionListExample),
    Exam(exam = "UERJ 2007 1ª Fase", questions = questionListExample),
    Exam(exam = "UERJ 2006 1ª Fase", questions = questionListExample),



)
private val fuvestExamListExample = listOf<Exam>(

    Exam(exam = "FUVEST 2021 Simulado", questions = questionListExample),
    Exam(exam = "FUVEST 2020 1ª Fase", questions = questionListExample),
    Exam(exam = "FUVEST 2019 1ª Fase", questions = questionListExample),
    Exam(exam = "FUVEST 2018 1ª Fase", questions = questionListExample),
    Exam(exam = "FUVEST 2017 1ª Fase", questions = questionListExample),
    Exam(exam = "FUVEST 2016 1ª Fase", questions = questionListExample),
    Exam(exam = "FUVEST 2015 1ª Fase", questions = questionListExample),
    Exam(exam = "FUVEST 2014 1ª Fase", questions = questionListExample),
    Exam(exam = "FUVEST 2013 1ª Fase", questions = questionListExample),
    Exam(exam = "FUVEST 2012 1ª Fase", questions = questionListExample),
    Exam(exam = "FUVEST 2011 1ª Fase", questions = questionListExample),
    Exam(exam = "FUVEST 2010 1ª Fase", questions = questionListExample),
    Exam(exam = "FUVEST 2009 1ª Fase", questions = questionListExample),
    Exam(exam = "FUVEST 2008 1ª Fase", questions = questionListExample),
    Exam(exam = "FUVEST 2007 1ª Fase", questions = questionListExample),
    Exam(exam = "FUVEST 2006 1ª Fase", questions = questionListExample),

)
private val convestExamListExample = listOf<Exam>(

    Exam(exam = "CONVEST 2021 Simulado", questions = questionListExample),
    Exam(exam = "CONVEST 2020 1ª Fase", questions = questionListExample),
    Exam(exam = "CONVEST 2019 1ª Fase", questions = questionListExample),
    Exam(exam = "CONVEST 2018 1ª Fase", questions = questionListExample),
    Exam(exam = "CONVEST 2017 1ª Fase", questions = questionListExample),
    Exam(exam = "CONVEST 2016 1ª Fase", questions = questionListExample),
    Exam(exam = "CONVEST 2015 1ª Fase", questions = questionListExample),
    Exam(exam = "CONVEST 2014 1ª Fase", questions = questionListExample),
    Exam(exam = "CONVEST 2013 1ª Fase", questions = questionListExample),
    Exam(exam = "CONVEST 2012 1ª Fase", questions = questionListExample),
    Exam(exam = "CONVEST 2011 1ª Fase", questions = questionListExample),
    Exam(exam = "CONVEST 2010 1ª Fase", questions = questionListExample),
    Exam(exam = "CONVEST 2009 1ª Fase", questions = questionListExample),
    Exam(exam = "CONVEST 2008 1ª Fase", questions = questionListExample),
    Exam(exam = "CONVEST 2007 1ª Fase", questions = questionListExample),
    Exam(exam = "CONVEST 2006 1ª Fase", questions = questionListExample),

)
private val actExamListExample = listOf<Exam>(

    Exam(exam = "ACT 2020-2021 Practice Test", questions = questionListExample),
    Exam(exam = "ACT 2019-2020 Practice Test", questions = questionListExample),
    Exam(exam = "ACT 2018-2019 Practice Test", questions = questionListExample),
    Exam(exam = "ACT 2017-2018 Practice Test", questions = questionListExample),
    Exam(exam = "ACT 2016-2017 Practice Test", questions = questionListExample),
    Exam(exam = "ACT 2015-2016 Practice Test", questions = questionListExample),
    Exam(exam = "ACT 2014-2015 Practice Test", questions = questionListExample),
    Exam(exam = "ACT 2013-2014 Practice Test", questions = questionListExample),
    Exam(exam = "ACT 2012-2013 Practice Test", questions = questionListExample),
    Exam(exam = "ACT 2011-2012 Practice Test", questions = questionListExample),
    Exam(exam = "ACT 2010-2011 Practice Test", questions = questionListExample),
    Exam(exam = "ACT 2009-2010 Practice Test", questions = questionListExample),
    Exam(exam = "ACT 2008-2009 Practice Test", questions = questionListExample),
    Exam(exam = "ACT 2007-2008 Practice Test", questions = questionListExample),

)
private val satExamListExample = listOf<Exam>(

    Exam(exam = "SAT 2020-2021 Practice Test", questions = questionListExample),
    Exam(exam = "SAT 2019-2020 Practice Test", questions = questionListExample),
    Exam(exam = "SAT 2018-2019 Practice Test", questions = questionListExample),
    Exam(exam = "SAT 2017-2018 Practice Test", questions = questionListExample),
    Exam(exam = "SAT 2016-2017 Practice Test", questions = questionListExample),
    Exam(exam = "SAT 2015-2016 Practice Test", questions = questionListExample),
    Exam(exam = "SAT 2014-2015 Practice Test", questions = questionListExample),
    Exam(exam = "SAT 2013-2014 Practice Test", questions = questionListExample),
    Exam(exam = "SAT 2012-2013 Practice Test", questions = questionListExample),
    Exam(exam = "SAT 2011-2012 Practice Test", questions = questionListExample),
    Exam(exam = "SAT 2010-2011 Practice Test", questions = questionListExample),
    Exam(exam = "SAT 2009-2010 Practice Test", questions = questionListExample),
    Exam(exam = "SAT 2008-2009 Practice Test", questions = questionListExample),
    Exam(exam = "SAT 2007-2008 Practice Test", questions = questionListExample),

)
private val toeflExamListExample = listOf<Exam>(

    Exam(exam = "TOEFL 2020-2021 Practice Test", questions = questionListExample),
    Exam(exam = "TOEFL 2019-2020 Practice Test", questions = questionListExample),
    Exam(exam = "TOEFL 2018-2019 Practice Test", questions = questionListExample),
    Exam(exam = "TOEFL 2017-2018 Practice Test", questions = questionListExample),
    Exam(exam = "TOEFL 2016-2017 Practice Test", questions = questionListExample),
    Exam(exam = "TOEFL 2015-2016 Practice Test", questions = questionListExample),
    Exam(exam = "TOEFL 2014-2015 Practice Test", questions = questionListExample),
    Exam(exam = "TOEFL 2013-2014 Practice Test", questions = questionListExample),
    Exam(exam = "TOEFL 2012-2013 Practice Test", questions = questionListExample),
    Exam(exam = "TOEFL 2011-2012 Practice Test", questions = questionListExample),
    Exam(exam = "TOEFL 2010-2011 Practice Test", questions = questionListExample),
    Exam(exam = "TOEFL 2009-2010 Practice Test", questions = questionListExample),
    Exam(exam = "TOEFL 2008-2009 Practice Test", questions = questionListExample),
    Exam(exam = "TOEFL 2007-2008 Practice Test", questions = questionListExample),

)
private val ieltsExamListExample = listOf<Exam>(

    Exam(exam = "IELTS 2020-2021 Practice Test", questions = questionListExample),
    Exam(exam = "IELTS 2019-2020 Practice Test", questions = questionListExample),
    Exam(exam = "IELTS 2018-2019 Practice Test", questions = questionListExample),
    Exam(exam = "IELTS 2017-2018 Practice Test", questions = questionListExample),
    Exam(exam = "IELTS 2016-2017 Practice Test", questions = questionListExample),
    Exam(exam = "IELTS 2015-2016 Practice Test", questions = questionListExample),
    Exam(exam = "IELTS 2014-2015 Practice Test", questions = questionListExample),
    Exam(exam = "IELTS 2013-2014 Practice Test", questions = questionListExample),
    Exam(exam = "IELTS 2012-2013 Practice Test", questions = questionListExample),
    Exam(exam = "IELTS 2011-2012 Practice Test", questions = questionListExample),
    Exam(exam = "IELTS 2010-2011 Practice Test", questions = questionListExample),
    Exam(exam = "IELTS 2009-2010 Practice Test", questions = questionListExample),
    Exam(exam = "IELTS 2008-2009 Practice Test", questions = questionListExample),
    Exam(exam = "IELTS 2007-2008 Practice Test", questions = questionListExample),

)
//============================
private val folderListExample = listOf<Folder>(

    Folder(folder = "Enem", enemExamListExample),
    Folder(folder = "UERJ", uerjExamListExample),
    Folder(folder = "FUVEST", fuvestExamListExample),
    Folder(folder = "CONVEST", convestExamListExample),
    Folder(folder = "ACT", actExamListExample),
    Folder(folder = "SAT", satExamListExample),
    Folder(folder = "TOEFL", toeflExamListExample),
    Folder(folder = "IELTS", ieltsExamListExample),

)



