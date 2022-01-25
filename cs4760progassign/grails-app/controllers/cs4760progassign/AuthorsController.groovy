package cs4760progassign

class AuthorsController {
    static final boolean debugIndex = true
    def index() {

        // Book.list() gets all Book instances from the database and puts them in a list.
        def bks = Book.listOrderByTitle()
        def aus = Author.listOrderByName()
        def bkList=[]
        def bksAuList = []

        // println outputs to console
        if(debugIndex){
            println ""
            aus.each{author -> println (author.name)
                author.books.title.each{println("     "+it)}}
        }

        for(int i=0; i < aus.size(); i++){
            def bkAuthor = [author:[:]]
            def bksMap = [:]
            bkAuthor.put('author', aus[i].name)
            for(int j=0; j<bks.size(); j++) {
                if(Author.get(bks[j].authorId).name == aus[i].name) {
                    bksAuList.add(bks[j].title)
                }
            }
            for(int k=0; k<bksAuList.size(); k++) {
                def key = 'title'+(k+1)
                bksMap.put(key, bksAuList.get(k))
            }
            bkAuthor.put('books',bksMap)
            bkList.add(bkAuthor)
            bksAuList.clear()
        }
        if(debugIndex){
            println " "
            println bkList
        }

        // So that the unit test can access the model, we need
        // to explicitly use the render method and specify the model.
        // We also have to explicitly specify the view, or
        // text will be rendered and not the view.
        render view: "index", model: [bkList: bkList]

        // If we did not have to access the model in the view
        // then we could use the default behavior and return
        // [bkList: bkList]
    }
}
