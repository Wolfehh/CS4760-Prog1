package cs4760progassign

class AuthorsController {
    static final boolean debugIndex = true
    def index() {

        // Book.list() gets all Book instances from the database and puts them in a list.
        def bks = Book.listOrderByTitle()
        def aus = Author.listOrderByName()
        def bkList=[]

        // println outputs to console
        if(debugIndex){
            println ""
            bks.each{ println it.title+" by "+Author.get(it.authorId).name}
        }

        // Make a list of all books title and authors
        for(int i=0; i < bks.size(); i++){
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
