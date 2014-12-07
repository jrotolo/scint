; eqv?
(define (eqv? obj1 obj2)
	(if (and (number? obj1) (number? obj2)) (= obj1 obj2) (eq? obj1 obj2)))

; equal?
(define (equal? obj1 obj2) 
	(cond ((eqv? obj1 obj2) #t)
		((and (pair? obj1) (pair? obj2) (equal? (car obj1) (car obj2)) (equal? (cdr obj1) (cdr obj2))) #t)
			(else #f)))


(define (+ . l) 
	(if (null? l) 
		0
		(b+ (car l) (apply + (cdr l)))))

(define (- . l)
	(if (null? l)
		0
		(b- (car l) (apply - (cdr l)))))

(define (* . l)
	(if (null? l)
		0
		(b* (car l) (apply * (cdr l)))))

; n-ary =
(define (= . l)
	(if (null? l) 0
		(b= (car l) (apply = (cdr l)))))

; n-ary >
(define (> . l)
	(if (null? l) 0
		(b> (car l) (apply > (cdr l)))))

; n-ary <
(define (< . l)
	(if (null? l) 0
		(b< (car l) (apply < (cdr l)))))

; n-ary >=
(define (>= . l)
	(if (null? l) 0
		(b>= (car l) (apply >= (cdr l)))))

; n-ary <=
(define (<= . l)
	(if (null? l) 0
		(b<= (car l) (apply <= (cdr l)))))

(define zero?
  (lambda (x)
    (if (= x 0)
      #t
      #f)))

;; positive?
(define positive?
  (lambda (x)
    (if (> x 0)
      #t
      #f)))

;; negative?
(define negative?
  (lambda (x)
    (if (< x 0)
      #t
      #f)))

;; odd?
(define odd?
  (lambda (x)
    (cond 
      ((= x 0) #f)
      ((= x 1) #t)
      ((positive? x) (odd? (- x 2)))
      ((negative? x) (odd? (+ x 2))))))

;; even?
(define even?
  (lambda (x)
    (cond
      ((= x 0) #t)
      ((= x 1) #f)
      ((positive? x) (even? (- x 2)))
      ((negative? x) (even? (+ x 2))))))

; and
(define and
	(lambda (x y)
		(cond (x 
			(cond (y #t) (else #f)))
		(else #f))))

; or
(define or
	(lambda (x y)
		(cond (x #t) 
			  (y #t) 
			  (else #f))))


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

; list
(define (list . l)
	(if (null? l) '()
	l))

; length
(define (length l)
	(if (null? l) 0
	(+ 1 (length (cdr l)))))

; append
(define (append l1 l2)
	(if (null? l1) l2
	(cons (car l1) (append (cdr l1) l2))))

; reverse
(define (reverse l)
	(if (null? l) '()
		(append (reverse (cdr l))
			(list (car l)))))

;max
(define (max . l)
  (if (= (length l) 1)
    (car l)
    (if (null? l)
      (write "wrong number of arguments")
      (if (> (car l) (apply max (cdr l)))
        (car l)
        (apply max (cdr l))))))

;; min
(define (min . l)
  (if (= (length l) 1)
    (car l)
    (if (null? l)
      (write "wrong number of arguments")
      (if (< (car l) (apply min (cdr l)))
        (car l)
        (apply min (cdr l))))))

; n-ary <=
; the set and association list operations 
; memv
(define (memv e l) 
	(if (null? l) #f 
		(if (eqv? e (car l)) #t 
			(memv e (cdr l)))))

; memq
(define (memq e l) 
	(if (null? l) #f 
		(if (eq? e (car l)) #t 
			(memq e (cdr l)))))

; member
(define (member e l) 
	(if (null? l) #f 
		(if (equal? e (car l)) #t 
			(member e (cdr l)))))

; assq
(define (assq e alist) 
	(if (null? alist) #f 
		(if (eq? e (caar alist)) (car alist) 
			(assq e (cdr alist)))))

; assv
(define (assv e alist) 
	(if (null? alist) #f 
		(if (eqv? e (caar alist)) (car alist) 
			(assv e (cdr alist)))))

;assoc
(define (assoc e alist) 
	(if (null? alist) #f 
		(if (equal? e (caar alist)) (car alist) 
			(assoc e (cdr alist)))))

; map
(define (map func lis)
 (if (null? (car lis)) '()
 	(cons (func (car lis) (map func (cdr lis))))))


; for-each
(define (for-each func lis)
 (if (not (null? (car lis))) '()
 	(begin
 		(apply func (map car lis))
 		(apply for-each func (map cdr l)))))
