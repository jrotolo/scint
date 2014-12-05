; list functions from caar ... cddddr
(define caar (lambda (x) (car (car x))))
(define cadr (lambda (x) (car (cdr x))))
(define cdar (lambda (x) (cdr (car x))))
(define cddr (lambda (X) (cdr (cdr x))))

(define caaar (lambda (x) (car (car (car x)))))
(define caadr (lambda (x) (car (car (cdr x)))))
(define cadar (lambda (x) (car (cdr (car x)))))
(define caddr (lambda (x) (car (cdr (cdr x)))))
(define cdaar (lambda (x) (cdr (car (car x)))))
(define cddar (lambda (x) (cdr (cdr (car x)))))
(define cdadr (lambda (X) (cdr (car (cdr x)))))
(define cdddr (lambda (x) (cdr (cdr (cdr x)))))

(define caaaar (lambda (x) (car (car (car (car x))))))
(define caaadr (lambda (x) (car (car (car (cdr x))))))
(define caadar (lambda (x) (car (car (cdr (car x))))))
(define caaddr (lambda (X) (car (car (cdr (cdr x))))))
(define cadaar (lambda (x) (car (cdr (car (car x))))))
(define caddar (lambda (X) (car (cdr (cdr (car x))))))
(define cadadr (lambda (x) (car (cdr (car (cdr x))))))
(define cadddr (lambda (x) (car (cdr (cdr (cdr x))))))
(define cdaaar (lambda (x) (cdr (car (car (car x))))))
(define cdaadr (lambda (x) (cdr (car (car (cdr x))))))
(define cdadar (lambda (x) (cdr (car (cdr (car x))))))
(define cdaddr (lambda (x) (cdr (car (cdr (cdr x))))))
(define cddaar (lambda (x) (cdr (cdr (car (car x))))))
(define cddadr (lambda (x) (cdr (cdr (car (cdr x))))))
(define cdddar (lambda (x) (cdr (cdr (cdr (car x))))))
(define cddddr (lambda (x) (cdr (cdr (cdr (cdr x))))))

(define (assert pred) (if pred (display "passed\n")(display "failed\n")))
(define l '((1 2) 3 4))

(assert (= (caar l) 1)) 
(assert (= (cadr l) 3))  
(assert (equal? (cdar l) '(2))) 
(assert (equal? (cddr l) '(4))) 

(define l2 '(((1 2) (3 4)) 5 6 (7 8)))
(assert (= (caar l) 1))
;(assert (= (caadr l) 5))
(assert (= (cadar l) 3))
(assert (= (caddr l) 6))
(assert (= (cdaar l) (2)))
(assert (= (cddar l) (4)))
;(assert cdadr (= ())
(assert (= (cddr l) '()))

; (assert caaaar 
; (assert caaadr 
; (assert caadar 
; (assert caaddr 
; (assert cadaar 
; (assert caddar 
; (assert cadadr 
; (assert cadddr 
; (assert cdaaar 
; (assert cdaadr 
; (assert cdadar 
; (assert cdaddr 
; (assert cddaar 
; (assert cddadr 
; (assert cdddar 
; (assert cddddr 