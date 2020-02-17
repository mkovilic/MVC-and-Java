using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using Zadatak.Models.Database;

namespace Zadatak.Controllers
{
    public class Servis1Controller : Controller
    {
        private PPPKEntities5 db = new PPPKEntities5();

        // GET: Servis1
        public ActionResult Index()
        {
            var servis = db.Servis.Include(s => s.KategorijaServi).Include(s => s.Vozila);
            return View(servis.ToList());
        }

        // GET: Servis1/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Servi servi = db.Servis.Find(id);
            if (servi == null)
            {
                return HttpNotFound();
            }
            return View(servi);
        }

        // GET: Servis1/Create
        public ActionResult Create()
        {
            ViewBag.KategorijaServisID = new SelectList(db.KategorijaServis, "IDKategorijaServis", "Naziv");
            ViewBag.VoziloID = new SelectList(db.Vozilas, "IDVozilo", "Tip");
            return View();
        }

        // POST: Servis1/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "IDServis,VoziloID,Cijena,Opis,Datum,KategorijaServisID")] Servi servi)
        {
            if (ModelState.IsValid)
            {
                db.Servis.Add(servi);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.KategorijaServisID = new SelectList(db.KategorijaServis, "IDKategorijaServis", "Naziv", servi.KategorijaServisID);
            ViewBag.VoziloID = new SelectList(db.Vozilas, "IDVozilo", "Tip", servi.VoziloID);
            return View(servi);
        }

        // GET: Servis1/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Servi servi = db.Servis.Find(id);
            if (servi == null)
            {
                return HttpNotFound();
            }
            ViewBag.KategorijaServisID = new SelectList(db.KategorijaServis, "IDKategorijaServis", "Naziv", servi.KategorijaServisID);
            ViewBag.VoziloID = new SelectList(db.Vozilas, "IDVozilo", "Tip", servi.VoziloID);
            return View(servi);
        }

        // POST: Servis1/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "IDServis,VoziloID,Cijena,Opis,Datum,KategorijaServisID")] Servi servi)
        {
            if (ModelState.IsValid)
            {
                db.Entry(servi).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.KategorijaServisID = new SelectList(db.KategorijaServis, "IDKategorijaServis", "Naziv", servi.KategorijaServisID);
            ViewBag.VoziloID = new SelectList(db.Vozilas, "IDVozilo", "Tip", servi.VoziloID);
            return View(servi);
        }

        // GET: Servis1/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Servi servi = db.Servis.Find(id);
            if (servi == null)
            {
                return HttpNotFound();
            }
            return View(servi);
        }

        // POST: Servis1/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Servi servi = db.Servis.Find(id);
            db.Servis.Remove(servi);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
