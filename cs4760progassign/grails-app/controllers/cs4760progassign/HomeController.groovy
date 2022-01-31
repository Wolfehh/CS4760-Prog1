package cs4760progassign

class HomeController {

    def index() { }
    private static final boolean debugTime = true //flag for debug printing
    def showTime() {
        if(debugTime)println "In showTime"
        render "The time is ${new Date()}"
    }
    def showLatestBook() {
        if(debugTime)println "In showLatestBook"
        render "${Book.listOrderByPublishYear().last().title} by ${Book.listOrderByPublishYear().last().author.name}"
    }
}
