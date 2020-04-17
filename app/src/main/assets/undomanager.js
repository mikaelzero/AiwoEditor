class Stack {
    constructor() {
        this.items = [];
        this.choose = 0;
    }
    push(html) {
        var element = {};
        element.html = html;
        element.range = this.saveRange();
        this.items.push(element);
        this.choose = this.items.length - 2;
    }
    pop() {
        return this.items.pop();
    }
    peek() {
        return this.items[this.items.length - 1];
    }
    isEmpty() {
        return !this.items.length;
    }
    clear() {
        this.items = [];
    }
    size() {
        return this.items.length;
    }
    getItem() {
        return this.items[this.choose];
    }
    undo(editor) {
        var currentItem = this.getItem(this.choose);
        editor.setHtml(currentItem.html);
        this.restoreRange(currentItem.range);
        this.choose--;
        // return currentItem.html;
    }
    saveRange() {
        const selection = window.getSelection();
        let range;

        if (selection.getRangeAt && selection.rangeCount) {
            range = selection.getRangeAt(0);
        } else {
            range = window.createRange();
        }

        return range;
    }
    restoreRange(range) {
        const selection = window.getSelection();
        selection.removeAllRanges();
        selection.addRange(range);
    }
}